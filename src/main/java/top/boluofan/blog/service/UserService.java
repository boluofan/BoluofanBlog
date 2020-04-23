package top.boluofan.blog.service;

import top.boluofan.blog.po.User;

/**
 * @author Boluofan
 * @className UserService
 * @TODO 用户接口
 * @Date 2020/4/23 16:45
 */
public interface UserService {
    /**
     * 根据用户名和密码查询用户
     * @param username
     * @param password
     * @return
     */
    User checkUser(String username,String password);
}
