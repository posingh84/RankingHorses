package se.atg.service.harrykart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Import;
import se.atg.service.harrykart.config.ApplicationConfiguration;
import se.atg.service.harrykart.config.SwaggerConfig;

@SpringBootApplication
@Import({ApplicationConfiguration.class, SwaggerConfig.class})
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.REGEX, pattern = "se.atg.*")})
public class HarryKartApplication {

    public static void main(String ... args) {

        SpringApplication.run(HarryKartApplication.class, args);
    }
}
