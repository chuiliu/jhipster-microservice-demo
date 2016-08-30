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
@Api(value = "/api", description = "测试", position = 1)
//可以自动刷新参数 环境变量刷新
@ConfigurationProperties
public class testConfigResource {

    @Value("${testData.name:defaultValue}")
    private String name;

    @Value("${testData.remark:defaultValue}")
    private String remark;

    @Value("${testData.introduction:defaultValue}")
    private String introduction;

    @RequestMapping(value = "test_name", method = RequestMethod.GET)
    public String testName() {
        return "name：" + name;
    }

    @RequestMapping(value = "test_remark", method = RequestMethod.GET)
    public String testRemark() {
        return "remark：" + remark;
    }

    @RequestMapping(value = "test_introduction", method = RequestMethod.GET)
    public String testIntroduction() {
        return "introduction：" + introduction;
    }
}
