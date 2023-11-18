package ltd.newbee.cloud.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "newbee-cloud-goods-service", path = "/goods")
public interface NewBeeGoodsDemoService {

    @GetMapping("/{goodsId}")
    String getGoodsDetail(@PathVariable("goodsId") int goodsId);

    @GetMapping(value = "/detail")
    String getGoodsDetail3(@RequestParam(value = "sellStatus") int sellStatus, @RequestParam(value = "goodsId") int goodsId);

    @GetMapping(value = "/listByIdArray")
    String[] getGoodsArray(@RequestParam(value = "goodsIds") Integer[] goodsIds);

    @GetMapping(value = "/listByIdList")
    List<String> getGoodsList(@RequestParam(value = "goodsIds") List<Integer> goodsIds);
}
