package ltd.newbee.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "newbee-cloud-shopcart-service", path = "/shop-cart")
public interface NewBeeShopCartDemoService {

    @GetMapping(value = "/{cartId}")
    String getCartItemDetail(@PathVariable(value = "cartId") int cartId);
}
