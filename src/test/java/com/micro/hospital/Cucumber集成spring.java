package com.micro.hospital;

import com.micro.hospital.service.Impl.UserInfoServiceI;
import cucumber.api.java.zh_cn.假如;
import cucumber.api.java.zh_cn.当;
import cucumber.api.java.zh_cn.那么;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration
//@SpringBootTest
public class Cucumber集成spring {

//    @Resource
//    private UserInfoServiceI service;
//
//    private String username;
//
//    private String password;
//
//    private String confirmPassword;
//
//    @假如("^:我以\"([^\"]*)\"登录$")
//    public void 我以_登录(String arg1) throws Throwable {
//        this.username = arg1;
//    }
//
//    @假如("^:输入的密码为\"([^\"]*)\"$")
//    public void 输入的密码为(String arg1) throws Throwable {
//        this.password = arg1;
//    }
//
//    @当("^:确认密码也为\"([^\"]*)\"时$")
//    public void 确认密码也为_时(String arg1) throws Throwable {
//        this.confirmPassword = arg1;
//    }
//
//    @那么("^:显示银行卡余额为\"([^\"]*)\"$")
//    public void 显示银行卡余额为(String arg1) throws Throwable {
//        boolean isLogin = service.login(username, password, confirmPassword);
//        if(isLogin){
//            System.out.println("登录成功！查询余额如下："+arg1);
//            Assert.assertEquals("500000", arg1);
//        }
//    }

}
