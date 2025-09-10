package top.yclu.week1.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {
    @Value("${my.feature.helloSwitch}")
    private boolean isHelloEnabled;

    @Value("${my.feature.closeMsg}")
    private String closeMessage;

    @GetMapping("/hello")
    public String hello(){
        // 根据开关判断返回内容
        if (isHelloEnabled) {
            return "接口开放中！欢迎访问我的第一个Spring Boot 项目～";
        } else {
            return closeMessage;
        }
    }
}
