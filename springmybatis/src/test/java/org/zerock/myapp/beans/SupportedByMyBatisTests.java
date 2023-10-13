package org.zerock.myapp.beans;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.myapp.mapper.CityMapper;
import org.zerock.myapp.mapper.HotelMapper;

import java.util.Arrays;

@Log4j2
@NoArgsConstructor

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

@AutoConfigureMockMvc
@SpringBootTest
class SupportedByMyBatisTests {

	//  MyBatis의 핵심 컴포넌트로, SQL 세션을 생성
	//  SQL 세션은 JDBC의 Connection을 추상화한 것으로, SQL 쿼리를 실행하거나 트랜잭션을 관리하는 역할
	@Setter(onMethod_ = @Autowired)
	private SqlSessionFactory sqlSessionFactory;

	// MyBatis를 사용하여 SQL 쿼리를 실행
	// SqlSession 인스턴스를 통해 CRUD 실행
	@Setter(onMethod_ = @Autowired)
	private SqlSession sqlSession;

	// MyBatis 설정 정보를 담는 클래스로, MyBatis의 여러 가지 설정 값을 가지고 있음
	@Setter(onMethod_ = @Autowired)
	private MybatisProperties mybatisProperties;

	@Setter(onMethod_ = @Autowired)
	private CityMapper cityMapper;  // MyBatis 매퍼 인터페이스로, City와 관련된 SQL 쿼리를 정의

	@Setter(onMethod_ = @Autowired)
	private HotelMapper hotelMapper; // MyBatis 매퍼 인터페이스로, Hotel과 관련된 SQL 쿼리를 정의


	@BeforeAll
	void beforeAll() {
		log.trace("beforeAll() invoked.");

		Assertions.assertThat(this.sqlSessionFactory).isNotNull(); // 들어온 값이 null인지 아닌지 검증
		log.info("\t this.sqlSessionFactory: {}", this.sqlSessionFactory);

		Assertions.assertThat(this.sqlSession).isNotNull(); // 들어온 값이 null인지 아닌지 검증
		log.info("\t this.sqlSession: {}", this.sqlSession);

		Assertions.assertThat(this.mybatisProperties).isNotNull(); // 들어온 값이 null인지 아닌지 검증
		log.info("\t this.mybatisProperties: {}", this.mybatisProperties);

		Assertions.assertThat(this.cityMapper).isNotNull(); // 들어온 값이 null인지 아닌지 검증
		log.info("\t this.cityMapper: {}", this.cityMapper);

		Assertions.assertThat(this.hotelMapper).isNotNull(); // 들어온 값이 null인지 아닌지 검증
		log.info("\t this.hotelMapper: {}", this.hotelMapper);


	} // beforeAll


	@Test   // 테스트
	void contextLoads() {
		log.trace("contextLoads() invoked.");

		String configLocation = this.mybatisProperties.getConfigLocation(); // MyBatis 설정 파일의 위치 가져옴
		log.info("\t configLocation: {}", configLocation);  // configLocation 변수의 값 출력

		String[] mapperLocations = this.mybatisProperties.getMapperLocations(); // MyBatis 매퍼 파일들의 위치를 가져옴
		log.info("\t mapperLocations: {}", Arrays.toString(mapperLocations)); // mapperLocations 배열의 내용을 문자열로 변환
	} // contextLoads

}// end class
