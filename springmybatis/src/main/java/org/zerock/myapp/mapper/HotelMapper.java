package org.zerock.myapp.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.zerock.myapp.domain.HotelVO;

@Mapper // MyBatis mapper 등록
public interface HotelMapper {

    // Using XML Mapper
    HotelVO selectByCity(Integer city);
} // end interface
