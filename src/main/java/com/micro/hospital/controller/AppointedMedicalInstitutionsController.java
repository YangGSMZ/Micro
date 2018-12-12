package com.micro.hospital.controller;

import com.alibaba.fastjson.JSONObject;
import com.micro.hospital.bean.Result;
import com.micro.hospital.bean.UserBean;
import com.micro.hospital.exception.UnauthorizedException;
import com.micro.hospital.service.AppointedMedicalInstitutionsService;
import com.micro.hospital.service.Impl.UserService;
import com.micro.hospital.util.JwtUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppointedMedicalInstitutionsController {

    @Autowired
    private AppointedMedicalInstitutionsService appointedMedicalInstitutionsService;
    private UserService userService;

    @Autowired
    public void setService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "province")
    public JSONObject queryByProvince(@RequestParam("province")String province){
        JSONObject result = appointedMedicalInstitutionsService.findByProvince(province);
        return result;
    }
    @GetMapping(value = "city")
    public JSONObject queryByCity(@RequestParam("city")String city){
        JSONObject result = appointedMedicalInstitutionsService.findByCity(city);
        return result;
    }
    @GetMapping(value = "hospital")
    public JSONObject queryByHospital(@RequestParam("hospital")String hospital) {
        JSONObject result = appointedMedicalInstitutionsService.findByMedicalInstitutionName(hospital);
        return result;
    }
    @GetMapping(value = "all")
    public JSONObject queryAll(@RequestParam("province")String province,@RequestParam("city")String city,@RequestParam("hospital")String hospital){
        JSONObject result = appointedMedicalInstitutionsService.findAll(province,city,hospital);
        return result;
    }
    @GetMapping(value = "level")
    public JSONObject orderByLevel(@RequestParam("level")String level){
        JSONObject result = appointedMedicalInstitutionsService.orderByLevel(level);
        return result;
    }

    @GetMapping("/require_role")
    @RequiresRoles("admin")
    public Result requireRole() {
        return new Result("200", "You are visiting require_role", null);
    }

    @PostMapping(value = "/login")
    public Result login(@RequestParam("username") String username,
                        @RequestParam("password") String password){
        UserBean userBean = userService.getUser(username);
        if (userBean.getPassword().equals(password)) {
            return new Result("200", "Login success", JwtUtil.sign(username, password));
        } else {
            throw new UnauthorizedException();
        }
    }

    @PatchMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Result unauthorized() {
        return new Result("401", "Unauthorized", null);
    }

    @PutMapping("/article")
    public Result article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return new Result("200", "You are already logged in", null);
        } else {
            return new Result("200", "You are guest", null);
        }
    }
}
