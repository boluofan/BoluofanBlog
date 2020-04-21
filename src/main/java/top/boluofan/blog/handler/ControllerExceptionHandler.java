package top.boluofan.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Boluofan
 * @className ControllerExceptionHandler
 * @TODO 自定义异常处理类
 * @Date 2020/4/17 15:19
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest request,Exception e) throws Exception {
        StringBuffer requestURL = request.getRequestURL();
        //记录日志
        logger.error("Request Url: {},Exception:{}",requestURL,e);
        //如果有异常处理类 交由spring处理
        if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        //设置返回值
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("url",requestURL);
        modelAndView.addObject("exception",e);
        //返回指定页面
        modelAndView.setViewName("error/error");
        return modelAndView;
    }
}
