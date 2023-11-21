package ltd.newbee.cloud.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class LoadBalancerTestController {

    @Resource
    private RestTemplate restTemplate;

    private final String SERVICE_URL = "http://newbee-cloud-goods-service";

    // 测试loadbalancer负载均衡
    @GetMapping("/loadBalancerTest")
    public String loadBalancerTest() {
        return restTemplate.getForObject(SERVICE_URL + "/goodsServiceTest", String.class);
    }
}
