package ltd.newbee.cloud.controller;

import ltd.newbee.cloud.openfeign.NewBeeGoodsDemoService;
import ltd.newbee.cloud.openfeign.NewBeeShopCartDemoService;
import ltd.newbee.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class NewBeeCloudOrderAPI {

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;
    @Resource
    private NewBeeShopCartDemoService newBeeShopCartDemoService;
    @Autowired
    private OrderService orderService;


    @GetMapping("/order/saveOrder")
    public String saveOrder(@RequestParam("cartId") int cartId, @RequestParam("goodsId") int goodsId) {
        // 简单的模拟下单流程，包括服务间的调用流程。后续openfeign相关的改造和优化将基于当前项目进行改造。

        // 调用商品服务
        String goodsResult = newBeeGoodsDemoService.getGoodsDetail(goodsId);
        // 调用购物车服务
        String cartResult = newBeeShopCartDemoService.getCartItemDetail(cartId);

        // 执行下单逻辑

        return "success! goodsResult={" + goodsResult + "},cartResult={" + cartResult + "}";
    }

    @GetMapping("/testChainApi1")
    public String testChainApi1() {
        String result = orderService.getNumber(2022);
        if ("BLOCKED".equals(result)){
            return "testChainApi1 error! "+result;
        }
        return "testChainApi1 success! "+result;
    }

    @GetMapping("/order/testChainApi2")
    public String testChainApi2() {
        String result = orderService.getNumber(2025);
        if ("BLOCKED".equals(result)){
            return "testChainApi2 error! "+result;
        }
        return "testChainApi2 success! "+result;
    }

    @GetMapping("/order/testRelateApi1")
    public String testRelateApi1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return "testRelateApi1 error!";
        }
        return "testRelateApi1 success!";
    }

    @GetMapping("/order/testRelateApi2")
    public String testRelateApi2() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            return "testRelateApi2 error!";
        }
        return "testRelateApi2 success!";
    }
}
