package com.micro.hospital.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.micro.hospital.bean.AppointedMedicalInstitutionsBean;
import com.micro.hospital.dao.AppointedMedicalInstitutionsDao;
import com.micro.hospital.service.AppointedMedicalInstitutionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointedMedicalInstitutionsServiceImpl implements AppointedMedicalInstitutionsService {

    @Autowired
    private AppointedMedicalInstitutionsDao appointedMedicalInstitutionsDao;

    @Override
    public JSONObject findByProvince(String province) {
        List<AppointedMedicalInstitutionsBean> query = appointedMedicalInstitutionsDao.findAllByAppointedMedicalInstitutionProvince(province);
        JSONObject result = new JSONObject();
        result.put("findAllByAppointedMedicalInstitutionProvince",query);
        return result;
    }

    @Override
    public JSONObject findByCity(String city) {
        List<AppointedMedicalInstitutionsBean> query = appointedMedicalInstitutionsDao.findAllByAreaName(city);
        JSONObject result = new JSONObject();
        result.put("findAllByAreaName",query);
        return result;
    }

    @Override
    public JSONObject findByMedicalInstitutionName(String hospital) {
        List<AppointedMedicalInstitutionsBean> query = appointedMedicalInstitutionsDao.findAllByAppointedMedicalInstitutionName(hospital);
        JSONObject result = new JSONObject();
        result.put("findAllByAppointedMedicalInstitutionName",query);
        return result;
    }

    @Override
    public JSONObject findAll(String province, String city, String hospital) {
        AppointedMedicalInstitutionsBean query = appointedMedicalInstitutionsDao.findAll(province,city,hospital);
        JSONObject result = new JSONObject();
        result.put("findAll",query);
        return result;
    }

    @Override
    public JSONObject orderByLevel(String level) {
        List<AppointedMedicalInstitutionsBean> query = appointedMedicalInstitutionsDao.orderByLevel(level);
        JSONObject result = new JSONObject();
        result.put("orderByLevel",query);
        return result;
    }
}
