package example.es.config;

import example.es.config.threadpool.AsyncThreadProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommonConfig {

    @Bean
    @ConfigurationProperties(prefix = "thread-pool")
    public AsyncThreadProperties getFocusUserConfig() {
        return new AsyncThreadProperties();
    }

}
