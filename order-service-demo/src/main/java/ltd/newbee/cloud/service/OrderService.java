package ltd.newbee.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @SentinelResource(value = "getNumber", blockHandler = "blockHandlerGetNumber")
    public String getNumber(int number) {
        return "number={" + number + "}";
    }

    public String blockHandlerGetNumber(int number, BlockException e) {
        return "BLOCKED";
    }
}
