package top.boluofan.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.boluofan.blog.dao.UserRepository;
import top.boluofan.blog.po.User;

/**
 * @author Boluofan
 * @className UserServiceImpl
 * @TODO 用户接口实现类
 * @Date 2020/4/23 16:49
 */
@Service
public class UserServiceImpl implements UserService {
    //注入dao
    @Autowired
    private UserRepository userRepository;
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username,password);
        return user;
    }
}
