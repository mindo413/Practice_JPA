package com.dhkim.practice_jpa;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dhkim.practice_jpa")) // 대상 패키지 설정
                .paths(PathSelectors.any()) // 노출시킬 api 설정(any:전부)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("JPA-Hibernate Spring Boot REST API")
                .version("1.0.0")
                .description("JPA 사용한 회원 데이터 관리 API 입니다.\n" + "Created by dhkim")
                .license("https://github.com/mindo413/Practice_JPA")
                .licenseUrl("https://github.com/mindo413/Practice_JPA")
                .build();
    }
}
