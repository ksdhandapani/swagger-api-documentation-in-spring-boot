package com.sakdd.hibernate;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Hibenate03CrudApplication {
	
	private static final Logger logger = LogManager.getLogger(Hibenate03CrudApplication.class);
	
	@Bean
    public Docket swagger() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.sakdd.hibernate.controller"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData());
    }

	private ApiInfo metaData() {
		return new ApiInfoBuilder().title("Employee Management REST API")
				.description("\"Spring Boot REST API for Employee Management\"").version("1.0.0")
				.license("Apache License Version 2.0").licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
				.contact(new Contact("Dhandapani Sudhakar", "https:dhandapanisudhakar.blogspot.com",
						"ksdhandapani96@gmail.com"))
				.build();
	}


	public static void main(String[] args) {
		SpringApplication.run(Hibenate03CrudApplication.class, args);
	}
	
	public void run(ApplicationArguments applicationArguments) throws Exception{
		logger.debug("Debugging log");
		logger.info("Info log");
		logger.warn("Warn log");
		logger.error("Error log");
		logger.fatal("Fatal log");
	}

}
