package ltd.newbee.cloud.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ltd.newbee.cloud.entity.NewBeeCartItem;
import ltd.newbee.cloud.entity.NewBeeGoodsInfo;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComplexObject {
    private int requestNum;

    private List<Integer> cartIds;

    private List<NewBeeGoodsInfo> newBeeGoodsInfos;

    private NewBeeCartItem newBeeCartItem;

    @Override
    public String toString() {
        return "ComplexObject{" +
                "requestNum=" + requestNum +
                ", cartIds=" + cartIds +
                ", newBeeGoodsInfos=" + newBeeGoodsInfos +
                ", newBeeCartItem=" + newBeeCartItem +
                '}';
    }
}
