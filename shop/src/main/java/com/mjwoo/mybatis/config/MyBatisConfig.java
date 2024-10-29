package com.mjwoo.mybatis.config;

import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

//여러 개의 매퍼를 사용하기 위해서는 매퍼 스캔 사용
// basePackages 설정시 해당 패키지 하위의 인터페이스는 매퍼로 등록,
// annotationClass 설정 시 @Mapper 붙은 인터페이스만 매퍼로 로드
/*
    매퍼 스캔 사용 방법
    1.<mybatis:scan/> 엘리먼트 사용(XML 기반 설정 방식)
    2. @MapperScan 어노테이션 사용(Java 기반 설정 방식)
    3. 스프링 XML 파일을 사용해서 MapperScannerConfigurer를 bean으로 등록(XML 기반 설정 방식)
*/

@Configuration
@Lazy
@RequiredArgsConstructor
@MapperScan(basePackages = {"com.mjwoo.mybatis.member"},
            annotationClass = org.apache.ibatis.annotations.Mapper.class)
public class MyBatisConfig {

    private final ApplicationContext context;

    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {

        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();

        sessionFactory.setDataSource(dataSource);
        //1. @Configuration을 통해서 DB 연결을 해당 클래스에서 하게 됨
        //   따라서 직접 빈 설정을 통해서 DataSource 연결

//        PathMatchingResourcePatternResolver resolve = new PathMatchingResourcePatternResolver();
        //

        sessionFactory.setMapperLocations(
            context.getResources("classpath:/mapper/*.xml")
            //실제 쿼리가 들어갈 xml 패키지 경로
        );
        //2. ApplicationContext를 통해서 Mapper쿼리를 읽어올 파일의 경로를 지정
        //   PathMatchingResourcePatternResolver도 같은 역할을 하는데
        // 두 인터페이스와 클래스는 경로를 설정할 때 차이가 있다.
        // PathMatchingResourcePatternResolver의 경우에는
        //sessionFactory.setMapperLocations(resolver.getResources(src/main/resources)) 이런 식으로 들어감

        sessionFactory.setTypeAliasesPackage("com.mjwoo.shop.domain");
        //Value Object를 선언해놓은 패키지 경로
        //Mapper의 result, parameterType의 패키지 경로를 클래스만 작성할 수 있게 도와줌


        return sessionFactory.getObject() ;
    }

    //MyBatis Template
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception{
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);

        sqlSessionTemplate.getConfiguration().setMapUnderscoreToCamelCase(true);

        return sqlSessionTemplate;
    }

    @Bean
    public DataSourceTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
