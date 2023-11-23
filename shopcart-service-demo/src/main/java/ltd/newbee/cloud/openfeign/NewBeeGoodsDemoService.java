package ltd.newbee.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "newbee-cloud-goods-service", path = "/goodsDetail2")
public interface NewBeeGoodsDemoService {

    @GetMapping("/{goodsId}")
    String getGoodsDetail2(@PathVariable(value = "goodsId") int goodsId);
}
