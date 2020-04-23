package top.boluofan.blog.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.boluofan.blog.constant.WebConstant;
import top.boluofan.blog.po.User;
import top.boluofan.blog.service.UserService;
import top.boluofan.blog.utils.MapCache;

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
                        @RequestParam (required = false) Boolean rememberMe,
                        HttpSession session) {
        Integer error_count = cache.get("login_error_count");
        try {
            User user = userService.checkUser(username, password);
            if (user != null) {//校验通过
                //存入session
                session.setAttribute(WebConstant.LOGIN_SESSION_KEY,user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
