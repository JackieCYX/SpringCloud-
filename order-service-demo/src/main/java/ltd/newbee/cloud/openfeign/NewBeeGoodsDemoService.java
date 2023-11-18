package ltd.newbee.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "newbee-cloud-goods-service", path = "/goods")
public interface NewBeeGoodsDemoService {

    @GetMapping("/{goodsId}")
    String getGoodsDetail(@PathVariable("goodsId") int goodsId);
}
