package ltd.newbee.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImpl {

    public String getName() {
        return "service01";
    }
}
