package in.mindcraft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ServletConfig {
	@Bean
    public ServletRegistrationBean<AddShowLaptopServlet> laptopServletRegistration() {
        ServletRegistrationBean<AddShowLaptopServlet> registrationBean =
                new ServletRegistrationBean<>(new AddShowLaptopServlet(), "/AddShowLaptopServlet");
        // Add more configuration if needed
        return registrationBean;
    }
}
