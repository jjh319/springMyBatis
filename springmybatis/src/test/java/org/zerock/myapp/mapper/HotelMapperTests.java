package org.zerock.myapp.mapper;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.myapp.domain.CityVO;
import org.zerock.myapp.domain.HotelVO;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@AutoConfigureMockMvc
@SpringBootTest
public class HotelMapperTests {
    @Setter(onMethod_ = @Autowired)  // 의존성 주입
    private HotelMapper hotelMapper;

    @Test
    @Order(1)
    @DisplayName("1. testSelectByCity")
    @Timeout(1L)
    void testSelectByCity() {
        log.trace("testSelectByCity() invoked.");

        Integer cityId = 1;
        HotelVO vo = hotelMapper.selectByCity(cityId);
        log.info("\t vo: {}", vo);
    } // testSelectByCity

} // end class
