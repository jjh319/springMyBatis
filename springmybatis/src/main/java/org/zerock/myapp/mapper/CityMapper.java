package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.zerock.myapp.domain.CityVO;

@Mapper  // MyBatis mapper 등록
public interface CityMapper {

    // Using MyBatis Annotations.
    @Select("SELECT * FROM city WHERE state = #{state}")
    CityVO findByState1(@Param("state") String state);

    // Using Mapper XML file.
    CityVO findByState2(@Param("id") Integer id);

} // end interface
