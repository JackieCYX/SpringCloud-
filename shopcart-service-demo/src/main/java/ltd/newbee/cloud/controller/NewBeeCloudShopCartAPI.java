package ltd.newbee.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewBeeCloudShopCartAPI {

    @Value("${server.port}")
    private String applicationServerPort;// 读取当前应用的启动端口

    @GetMapping("/shop-cart/{cartId}")
    public String cartItemDetail(@PathVariable("cartId") int cartId) {
        // 根据id查询商品并返回给调用端
        if (cartId < 0 || cartId > 100000) {
            return "查询购物项为空，当前服务的端口号为" + applicationServerPort;
        }
        String cartItem = "购物项" + cartId;
        // 返回信息给调用端
        return cartItem + "，当前服务的端口号为" + applicationServerPort;
    }
}
