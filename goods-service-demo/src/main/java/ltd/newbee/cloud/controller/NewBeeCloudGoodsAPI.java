package ltd.newbee.cloud.controller;

import ltd.newbee.cloud.entity.NewBeeGoodsInfo;
import ltd.newbee.cloud.param.ComplexObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NewBeeCloudGoodsAPI {

    @Value("${server.port}")
    private String applicationServerPort;

    @GetMapping("/goods/{goodsId}")
    public String goodsDetail(@PathVariable("goodsId") int goodsId) {
        // 根据id查询商品并返回给调用端
        if (goodsId < 1 || goodsId > 100000) {
            return "查询商品为空，当前服务的端口号为" + applicationServerPort;
        }
        String goodsName = "商品" + goodsId;
        // 返回信息给调用端
        return goodsName + "，当前服务的端口号为" + applicationServerPort;
    }

    @GetMapping("/goods/detail")
    //传递多个参数 参数都是URL参数
    public String goodsDetailByParams(@RequestParam("sellStatus") int sellStatus, @RequestParam("goodsId") int goodsId) {

        System.out.println("参数如下：sellStatus=" + sellStatus + ",goodsId=" + goodsId);

        // 根据id查询商品并返回给调用端
        if (goodsId < 1 || goodsId > 100000) {
            return "goodsDetailByParams 查询商品为空，当前服务的端口号为" + applicationServerPort;
        }
        String goodsName = "商品" + goodsId + ",上架状态 "+sellStatus;
        // 返回信息给调用端
        return "goodsDetailByParams " + goodsName + "，当前服务的端口号为" + applicationServerPort;
    }

    @GetMapping("/goods/listByIdArray")
    //传递数组类型
    public String[] listByIdArray(@RequestParam("goodsIds") Integer[] goodsIds) {

        // 根据goodsIds查询商品并返回给调用端
        if (goodsIds.length < 1) {
            return null;
        }

        String[] goodsInfos = new String[goodsIds.length];

        for (int i = 0; i < goodsInfos.length; i++) {
            goodsInfos[i] = "商品" + goodsIds[i];
        }

        // 接收参数为数组，返回信息给调用端亦为数组类型
        return goodsInfos;
    }

    @GetMapping("/goods/listByIdList")
    //传递链表类型
    public List<String> listByIdList(@RequestParam("goodsIds") List<Integer> goodsIds) {

        // 根据goodsIds查询商品并返回给调用端
        if (CollectionUtils.isEmpty(goodsIds)) {
            return null;
        }

        List<String> goodsInfos = new ArrayList<>();

        for (int goodsId : goodsIds) {
            goodsInfos.add("商品" + goodsId);
        }

        // 接收参数为链表，返回信息给调用端亦为链表类型
        return goodsInfos;
    }

    @PostMapping("/goods/updNewBeeGoodsInfo")
    public NewBeeGoodsInfo updNewBeeGoodsInfo(@RequestBody NewBeeGoodsInfo newBeeGoodsInfo) {
        if (newBeeGoodsInfo.getGoodsId() > 0) {
            int stock = newBeeGoodsInfo.getStock();
            stock -= 1;
            //库存减一
            newBeeGoodsInfo.setStock(stock);
        }

        return newBeeGoodsInfo;
    }

    @PostMapping("/goods/testComplexObject")
    public ComplexObject testComplexObject(@RequestBody ComplexObject complexObject) {

        int requestNum = complexObject.getRequestNum();
        requestNum -= 1;
        complexObject.setRequestNum(requestNum);

        // 由于字段过多，这里就用debug的方式来查看接收到的复杂对象参数
        return complexObject;
    }

    @GetMapping("/goodsDetail2/{goodsId}")
    public String goodsDetail2(@PathVariable("goodsId") int goodsId) {
        // 根据id查询商品并返回给调用端
        if (goodsId < 1 || goodsId > 100000) {
            return "查询商品为空，当前服务的端口号为" + applicationServerPort;
        }
        String goodsName = "商品" + goodsId;
        // 返回信息给调用端
        return goodsName + "，当前服务的端口号为" + applicationServerPort;
    }
}
