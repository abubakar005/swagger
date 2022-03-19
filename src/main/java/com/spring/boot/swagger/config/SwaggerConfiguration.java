package com.spring.boot.swagger.config;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
//@EnableWebMvc
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //.apis(RequestHandlerSelectors.any())
               // .apis(RequestHandlerSelectors.basePackage("com.spring.boot.swagger.resource"))                //** For load specific packages *//
                //.paths(PathSelectors.any())
                //.paths(PathSelectors.ant("/api/*"))         //** Path of the Apis*//
                .paths(Predicates.or(
                        PathSelectors.ant("/api/*"),
                        PathSelectors.ant("/api/v2/*")))
                .build()
                .apiInfo(getApiInfo());
    }

    /** For add additional models explicitly */
    /*
    @Bean
    public Docket api(TypeResolver typeResolver) {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/api/v1/**"))
                .build()
                .additionalModels(typeResolver.resolve(CustomerDTO.class));
    }

*/
    /*@Bean
    public WebMvcConfigurer webMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers( ResourceHandlerRegistry registry ) {
                registry.addResourceHandler( "swagger-ui.html" ).addResourceLocations( "classpath:/META-INF/resources/" );
                registry.addResourceHandler( "/webjars/**" ).addResourceLocations( "classpath:/META-INF/resources/webjars/" );
            }
        };
    }*/

    private ApiInfo getApiInfo() {
        return new ApiInfo(
                "Contacts Api Documentations",
                "Apis for Contact Details",
                "1.0",
                "",
                 new Contact("Abu Bakar", "www.google.com", "abcd@gmail.com"),
                "Free to Use",
                "Nill",
                Collections.emptyList()
        );
    }
}
