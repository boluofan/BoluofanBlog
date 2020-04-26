package top.boluofan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.boluofan.blog.dao.ConfigRepository;
import top.boluofan.blog.po.Config;

/**
 * @author Boluofan
 * @className ConfigServiceImpl
 * @TODO 配置接口实现类
 * @Date 2020/4/26 14:22
 */
@Service
public class ConfigServiceImpl implements ConfigService{

    @Autowired
    ConfigRepository configRepository;
    @Override
    public String getConfigValueByKey(String key) {
        String configValue = null;//配置值
        System.out.println("key ："+key);
        Config config = configRepository.findByKey(key);
        if (null != config) configValue = config.getValue();
        System.out.println("123poihg: "+configValue);
        return configValue;
    }
}
