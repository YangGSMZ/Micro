package com.micro.hospital.dao;

import com.micro.hospital.bean.AppointedMedicalInstitutionsBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointedMedicalInstitutionsDao{

    //按照省
    List<AppointedMedicalInstitutionsBean> findAllByAppointedMedicalInstitutionProvince(String province);

    //按照市
    List<AppointedMedicalInstitutionsBean> findAllByAreaName(String city);

    //按照医院名称
    List<AppointedMedicalInstitutionsBean> findAllByAppointedMedicalInstitutionName(String hospital);

    //按照以上属性
    AppointedMedicalInstitutionsBean findAll(String province,String city,String hospital);

    //按照医院等级排序
    List<AppointedMedicalInstitutionsBean> orderByLevel(String level);

}
