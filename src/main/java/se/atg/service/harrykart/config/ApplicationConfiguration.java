package se.atg.service.harrykart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import se.atg.service.harrykart.rest.HarryKartController;
import se.atg.service.harrykart.service.HarryKartService;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public HarryKartController harryKartController(final HarryKartService harryKartService) {

        return new HarryKartController(harryKartService);
    }

    @Bean
    public HarryKartService harryKartService() {

        return new HarryKartService();
    }
}
