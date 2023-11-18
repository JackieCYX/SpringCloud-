package ltd.newbee.cloud.controller;

import ltd.newbee.cloud.entity.NewBeeGoodsInfo;
import ltd.newbee.cloud.openfeign.NewBeeGoodsDemoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudTestObjectAPI {

    @Resource
    private NewBeeGoodsDemoService simpleObjectService;

    @GetMapping("/order/simpleObjectTest")
    public String simpleObjectTest1() {

        NewBeeGoodsInfo newBeeGoodsInfo = new NewBeeGoodsInfo();
        newBeeGoodsInfo.setGoodsId(2022);
        newBeeGoodsInfo.setGoodsName("Spring Cloud Alibaba 微服务架构");
        newBeeGoodsInfo.setStock(2035);

        NewBeeGoodsInfo result = simpleObjectService.updNewBeeGoodsInfo(newBeeGoodsInfo);

        return result.toString();
    }
}
