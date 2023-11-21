package ltd.newbee.cloud.web;

import ltd.newbee.cloud.service.HelloService2Impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloService2Controller {

    @Autowired
    private HelloService2Impl helloService;

    @GetMapping("/hello")
    public String hello() {
        // 调用本地方法，并通过HTTP协议进行响应
        return "hello from " + helloService.getName();
    }
}
