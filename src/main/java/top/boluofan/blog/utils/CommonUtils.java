package top.boluofan.blog.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import top.boluofan.blog.constant.WebConstant;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Boluofan
 * @className CommonUtils
 * @TODO    常用工具类
 * @Date 2020/4/23 17:33
 */
public class CommonUtils {

    public static void main(String[] args) {
        String s = md5Encode("111111" + "123poihg");
        System.out.println(s);
    }

    /**
     * MD5加密类
     * @param str 要加密的字符串
     * @return    加密后的字符串
     */
    public static String md5Encode(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[]byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 设置记住密码cookie
     *
     * @param response
     * @param data 数据
     * @param seconds 过期时间 s
     */
    public static void setCookie(HttpServletResponse response, String data,Integer seconds) {
        try {
            String val = enAes(data,WebConstant.AES_SALT);
            boolean isSSL = false;
            Cookie cookie = new Cookie(WebConstant.USER_COOKIE_NAME, val);
            cookie.setPath("/");
            cookie.setMaxAge(seconds);
            cookie.setSecure(isSSL);
            response.addCookie(cookie);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //AES加密
    public static String enAes(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = cipher.doFinal(data.getBytes());
        return new BASE64Encoder().encode(encryptedBytes);
    }

    //AES解密
    public static String deAes(String data, String key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] cipherTextBytes = new BASE64Decoder().decodeBuffer(data);
        byte[] decValue = cipher.doFinal(cipherTextBytes);
        return new String(decValue);
    }
}

