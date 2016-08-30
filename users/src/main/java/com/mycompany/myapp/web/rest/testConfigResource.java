package com.mycompany.myapp.web.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2016/8/30.
 */
@RestController
@RequestMapping("/api")
@Api(value = "/api", description = "test", position = 1)
// 测试自动刷新配置
@ConfigurationProperties
public class testConfigResource {

    @Value("${testData.user.id:defaultValue}")
    private String id;

    @Value("${testData.user.name:defaultValue}")
    private String name;

    @Value("${testData.user.remark:defaultValue}")
    private String remark;

    @RequestMapping(value = "test_id", method = RequestMethod.GET)
    public String testIntroduction() {
        return "id：" + id;
    }

    @RequestMapping(value = "test_name", method = RequestMethod.GET)
    public String testName() {
        return "name：" + name;
    }

    @RequestMapping(value = "test_remark", method = RequestMethod.GET)
    public String testRemark() {
        return "remark：" + remark;
    }


}
