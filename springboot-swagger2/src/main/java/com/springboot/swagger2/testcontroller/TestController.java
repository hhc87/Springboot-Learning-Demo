package com.springboot.swagger2.testcontroller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Andrew He
 * @Date: Created in 20:19 2018/5/6
 * @Description:
 * @Modified by:
 */
@RestController
@RequestMapping("/")
public class TestController {

    // @ApiOperation      接口描述
    // @ApiImplicitParam  单参数描述
    // @ApiImplicitParams 多参数描述

    @GetMapping(value = "/testone")
    @ResponseBody
    @ApiOperation(value = "单个参数测试", notes = "单个参数测试")
    @ApiImplicitParam(name = "parameter1", value = "测试参数1", required = true, dataType = "String")
    public String interfaceWithOneParameter(@RequestParam(value = "parameter1", required = true) String parameter1) {

        return parameter1 != null ? "Welcome Swagger2" : "Wrong parameter";
    }

    @PostMapping(value = "/testmany")
    @ResponseBody
    @ApiOperation(value = "多参数测试", notes = "多参数测试")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parameter1", value = "测试参数1", required = true, dataType = "String"),
            @ApiImplicitParam(name = "parameter2", value = "测试参数2", required = true, dataType = "String")})
    public String interfaceWithManyParameter(@RequestParam(value = "parameter1", required = true) String parameter1,
                                             @RequestParam(value = "parameter2", required = true) String parameter2) {

        return parameter1 != null ? parameter2 != null ? "Welcome Swagger2" : "Wrong parameter" : "Wrong parameter";
    }

}
