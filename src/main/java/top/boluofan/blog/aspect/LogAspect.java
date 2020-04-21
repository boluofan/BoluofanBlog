package top.boluofan.blog.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Boluofan
 * @className LogAspect
 * @TODO 日志处理aop
 * @Date 2020/4/17 16:27
 */
@Aspect
@Component
public class LogAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * 自定义切面 web下所有类所有方法任何参数
     */
    @Pointcut("execution(* top.boluofan.blog.web.*.*(..))")
    public void log(){

    }

    /**
     *
     * @param joinPoint 切面对象
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        logger.info("---before");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //切面属性
        Signature signature = joinPoint.getSignature();
        String classMethod = signature.getDeclaringTypeName()+"."+signature.getName();
        Object[] args = joinPoint.getArgs();
        RequestLog requestLog = new RequestLog(url, ip, classMethod, args);
        logger.info("Request : {}",requestLog);

    }
    @After("log()")
    public void doAfter(){
        //logger.info("----after");
    }

    @AfterReturning(returning = "result",pointcut = "log()")
    public void afterReturn(Object result){
        logger.info("Result : {} ",result);
    }

    //定义请求日志类
    private class RequestLog{
        private String url;
        private String ip;
        private String classMethod;
        private Object[] args;//请求参数

        public RequestLog(String url, String ip, String classMethod, Object[] args) {
            this.url = url;
            this.ip = ip;
            this.classMethod = classMethod;
            this.args = args;
        }

        @Override
        public String toString() {
            return "{" +
                    "url='" + url + '\'' +
                    ", ip='" + ip + '\'' +
                    ", classMethod='" + classMethod + '\'' +
                    ", args=" + Arrays.toString(args) +
                    '}';
        }
    }
}
