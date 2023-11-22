package ltd.newbee.cloud.service;

import ltd.newbee.cloud.openfeign.NewBeeGoodsDemoService;
import ltd.newbee.cloud.openfeign.NewBeeShopCartDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Resource
    private NewBeeGoodsDemoService newBeeGoodsDemoService;

    @Resource
    private NewBeeShopCartDemoService newBeeShopCartDemoService;

    @Transactional
    public Boolean saveOrder(int cartId) {
        // 简单的模拟下单流程，包括服务间的调用流程。

        // 调用购物车服务-获取即将操作的goods_id
        int goodsId = newBeeShopCartDemoService.getGoodsId(cartId);

        // 调用商品服务-减库存
        Boolean goodsResult = newBeeGoodsDemoService.deStock(goodsId);

        // 调用购物车服务-删除当前购物车数据
        Boolean cartResult = newBeeShopCartDemoService.deleteItem(cartId);

        // 执行下单逻辑
        if (goodsResult && cartResult) {
            // 向订单表中新增一条记录
            int orderResult = jdbcTemplate.update("insert into tb_order(`cart_id`) value (\"" + cartId + "\")");
            // 此处出现了异常
            int i = 1/0;
            if (orderResult > 0) {
                return true;
            }
            return false;
        }
        return false;
    }
}
