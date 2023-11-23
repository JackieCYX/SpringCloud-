package ltd.newbee.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(clients = {ltd.newbee.cloud.openfeign.NewBeeGoodsDemoService.class})
public class ShopCartServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCartServiceApplication.class, args);
    }

}
