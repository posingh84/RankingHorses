package se.atg.service.harrykart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private static final Tag TAG = new Tag("HarryKart Ranking System", "Fetch top 3 fastest participating horses");

    @Bean
    public Docket harryKartApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("se.atg.service.harrykart"))
                .paths(PathSelectors.any())
                .build()
                .tags(TAG)
                .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo() {

        return new ApiInfoBuilder()
                .title("WEB API for Harry Kart Ranking Apllication")
                .description("This API was built for the ATG home assignment of ranking services")
                .build();
    }


}

