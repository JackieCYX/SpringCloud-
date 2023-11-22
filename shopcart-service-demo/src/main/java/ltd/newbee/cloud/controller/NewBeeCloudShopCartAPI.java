package ltd.newbee.cloud.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class NewBeeCloudShopCartAPI {

    @Value("${server.port}")
    private String applicationServerPort;// 读取当前应用的启动端口

    @Autowired
    private JdbcTemplate jdbcTemplate;

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

    @GetMapping("/shop-cart/getGoodsId")
    public int getGoodsId(@RequestParam("cartId") int cartId) {
        // 根据主键id查询购物表
        Map<String, Object> cartItemObject = jdbcTemplate.queryForMap("select * from tb_cart_item where cart_id=" + cartId + " limit 1");
        if (cartItemObject.containsKey("goods_id")) {
            // 返回商品id
            return (int) cartItemObject.get("goods_id");
        }
        return 0;
    }

    @DeleteMapping("/shop-cart/{cartId}")
    public Boolean deleteItem(@PathVariable("cartId") int cartId) {
        // 删除购物车数据
        int result = jdbcTemplate.update("delete from tb_cart_item where cart_id=" + cartId);
        if (result > 0) {
            return true;
        }
        return false;
    }
}
