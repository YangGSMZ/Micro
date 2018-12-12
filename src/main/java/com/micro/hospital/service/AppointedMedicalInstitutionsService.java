package com.micro.hospital.service;


import com.alibaba.fastjson.JSONObject;

public interface AppointedMedicalInstitutionsService {
    //通过省份
    JSONObject findByProvince(String province);

    JSONObject findByCity(String city);

    JSONObject findByMedicalInstitutionName(String hospital);

    JSONObject findAll(String province,String city,String hospital);

    JSONObject orderByLevel(String level);

}
