package ru.lugom.config;

import com.maxmind.db.Reader;
import com.maxmind.geoip2.DatabaseReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class GeoLocationConfig {

    private static DatabaseReader reader = null;
    private final ResourceLoader resourceLoader;

    public GeoLocationConfig(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public DatabaseReader databaseReader() {
        try {
            Resource resource = resourceLoader.getResource("classpath:maxmind/GeoLite2-City.mmdb");
            InputStream dbAsStream = resource.getInputStream();

            return reader = new DatabaseReader
                    .Builder(dbAsStream)
                    .fileMode(Reader.FileMode.MEMORY)
                    .build();

        } catch (IOException | NullPointerException e) {
            return null;
        }
    }
}
