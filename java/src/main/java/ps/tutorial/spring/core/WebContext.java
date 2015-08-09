package ps.tutorial.spring.core;

import org.springframework.context.annotation.*;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.*;

import java.util.List;

@Configuration
@Import(Beans.class)
@EnableWebMvc
@ComponentScan(basePackages = {"ps.tutorial.spring.core.controllers"})
public class WebContext extends WebMvcConfigurerAdapter {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        // Add formatters and/or converters
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // Configure the list of HttpMessageConverters to use
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Add some request interceptors
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        // Configure custom content negotiation strategy (for json, xml and so on)
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // "../hello" request will be handled by "index" view immediately
        registry.addViewController("/hello").setViewName("index");
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // Already enabled by default
        //// registry.enableContentNegotiation(new MappingJackson2JsonView());
        registry.jsp("/WEB-INF/views/", ".jspx");
        // Use short form instead of:
        //// InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        //// resolver.setPrefix("");
        //// resolver.setSuffix(".jspx");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/public-resources/");
    }

}
