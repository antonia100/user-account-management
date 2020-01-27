package user.account.management.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserAccountManagementConfig implements WebMvcConfigurer {

    private static final String FRONTED_ORIGIN = "http://localhost:3000";
    private static final String[] FRONTED_METHODS = new String[]{"GET", "POST", "DELETE"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(FRONTED_ORIGIN)
                .allowedMethods(FRONTED_METHODS);
    }
}
