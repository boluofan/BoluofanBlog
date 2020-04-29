package top.boluofan.blog.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import top.boluofan.blog.po.Config;

/**
 * @author Boluofan
 * @className ConfigRepository
 * @TODO 配置dao接口
 * @Date 2020/4/26 14:24
 */
public interface ConfigRepository extends JpaRepository<Config,Long> {
    Config findByKey(String key);
}
