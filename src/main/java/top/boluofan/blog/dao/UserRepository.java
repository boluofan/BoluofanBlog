package top.boluofan.blog.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import top.boluofan.blog.po.User;

/**
 * @author Boluofan
 * @className UserRepository
 * @TODO 用户dao接口类
 * @Date 2020/4/23 16:52
 */
public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsernameAndPassword(String username,String password);
}
