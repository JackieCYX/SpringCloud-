package ltd.newbee.cloud.controller;

import ltd.newbee.cloud.openfeign.NewBeeGoodsDemoService;
import ltd.newbee.cloud.openfeign.NewBeeShopCartDemoService;
import ltd.newbee.cloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private OrderService orderService;

    @GetMapping("/order/saveOrder")
    public Boolean saveOrder(@RequestParam("cartId") int cartId) {
        return orderService.saveOrder(cartId);
    }
}
