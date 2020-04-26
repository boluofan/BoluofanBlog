package top.boluofan.blog.service;

/**
 * @author Boluofan
 * @className ConfigService
 * @TODO 配置接口
 * @Date 2020/4/26 14:18
 */
public interface ConfigService {
    /**
     * 通过key获取配置信息
     * @param key
     * @return
     */
    String getConfigValueByKey (String key);
}
