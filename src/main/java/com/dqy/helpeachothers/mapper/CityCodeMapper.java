package com.dqy.helpeachothers.mapper;

import com.dqy.helpeachothers.entity.CityCode;

import com.dqy.helpeachothers.entity.Emergency;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;

@Mapper
public interface CityCodeMapper {
    String tableName="citycode";
    @Select("select * from "+tableName)
    List<CityCode> select();
//    查询所有
    List<CityCode> findAll();

    CityCode getByAdcode(@Param("adcode") Integer adcode);
}
