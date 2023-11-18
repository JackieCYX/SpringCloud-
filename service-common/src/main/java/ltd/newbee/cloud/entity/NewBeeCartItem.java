package ltd.newbee.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewBeeCartItem {

    private int itemId;

    private String cartString;

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append(" itemId=").append(itemId);
        sb.append(", cartString=").append(cartString);
        sb.append("]");
        return sb.toString();
    }
}
