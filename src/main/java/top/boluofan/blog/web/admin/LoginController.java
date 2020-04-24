package top.boluofan.blog.web.admin;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import top.boluofan.blog.constant.WebConstant;
import top.boluofan.blog.po.User;
import top.boluofan.blog.service.UserService;
import top.boluofan.blog.utils.CommonUtils;
import top.boluofan.blog.utils.MapCache;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Boluofan
 * @className LoginController
 * @TODO 登录控制层
 * @Date 2020/4/23 17:00
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    private MapCache cache = MapCache.single();
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    UserService userService;

    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        @RequestParam String validateCode,
                        @RequestParam(required = false) Boolean rememberMe,
                        HttpServletResponse response,
                        HttpSession session,
                        RedirectAttributes redirectAttributes) {
        Integer error_count = cache.get("login_error_count");
        try {
            String errMessage = "";
            if (StringUtils.isNotBlank(validateCode)) {
                validateCode = validateCode.toLowerCase();//转小写
                String sessionVC = session.getAttribute("sessionVC").toString();
                sessionVC = "111";
                if (validateCode.equals(sessionVC)){
                    User user = userService.checkUser(username, password);
                    if (user != null) {//校验通过
                        //是否需要存入 cookie
                        if (rememberMe){
                            String userIdStr = user.getId().toString();
                            CommonUtils.setCookie(response,userIdStr,60*60*24*7);
                        }
                        // 重置密码并存入session
                        user.setPassword("");
                        session.setAttribute(WebConstant.LOGIN_SESSION_KEY, user);
                        return "admin/index";
                    }else {
                        errMessage = "用户名或密码错误，请重新输入";
                        redirectAttributes.addFlashAttribute("errMessage",errMessage);
                        return "redirect:/admin";
                    }
                }else {
                    error_count = null == error_count ? 1 : error_count + 1;
                    if (error_count >= 3) errMessage = "验证码输入错误三次，请稍后再试";
                    else errMessage = "验证码错误，请重新输入";
                    cache.set("login_error_count", error_count, 10 * 60);
                    redirectAttributes.addFlashAttribute("errMessage",errMessage);
                    return "redirect:/admin";
                }
            } else {
                errMessage = "验证码为空，请重新输入";
                redirectAttributes.addFlashAttribute("errMessage",errMessage);
                return "redirect:/admin";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/admin";
        }
    }

    /**
     *
     * @return
     */
    @GetMapping("/logout")
    public String logout (HttpSession session){
        session.removeAttribute(WebConstant.LOGIN_SESSION_KEY);
        return "redirect:/admin";
    }
}
