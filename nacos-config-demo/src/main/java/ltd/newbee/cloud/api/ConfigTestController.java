package ltd.newbee.cloud.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope // 配置自动更新
public class ConfigTestController {

    // 在配置中心填写的配置项（默认值为false）
    @Value("${activitySwitch.val:false}")
    private Boolean activitySwitch;

    @GetMapping("/configTest")
    public String configTest() {
        if (activitySwitch) {
            return "活动页面渲染所需数据";
        } else {
            return "活动未开启";
        }
    }
}
