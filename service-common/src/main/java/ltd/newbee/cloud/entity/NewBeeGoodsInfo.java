package ltd.newbee.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewBeeGoodsInfo {
    private Integer goodsId;
    private String goodsName;
    private Integer stock;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(" goodsName=").append(goodsName);
        sb.append(", goodsId=").append(goodsId);
        sb.append(", stock=").append(stock);
        sb.append("]");
        return sb.toString();
    }
}
