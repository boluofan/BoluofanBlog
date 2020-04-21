package top.boluofan.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import top.boluofan.blog.NotFoundException;

/**
 * @author Boluofan
 * @className IndexController
 * @Date 2020/4/17 15:07
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        String blog = null;
        /*if (blog == null){
            throw  new NotFoundException("博客找不到");
        }*/
        return "index";
    }
    @GetMapping("/index")
    public String loginndex(){
        return "index";
    }
    @GetMapping("/about")
    public String about(){
        return "about";
    }
}
