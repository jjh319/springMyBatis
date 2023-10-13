package org.zerock.myapp.mapper;


import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.myapp.domain.CityVO;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@AutoConfigureMockMvc
@SpringBootTest
public class CityMapperTests {
    @Setter(onMethod_ = @Autowired)
    private CityMapper cityMapper;

    @Test
    @Order(1)
    @DisplayName("1. testFindByState1")
    @Timeout(1L)
    void testFindByState1() {
        log.trace("contextLoads() invoked.");

        CityVO vo = cityMapper.findByState1("CA");
        log.info("\t vo: {}", vo);
    } // testFindByState1

} // end class
