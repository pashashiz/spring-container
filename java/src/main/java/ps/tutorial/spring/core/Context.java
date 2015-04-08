package ps.tutorial.spring.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import ps.tutorial.spring.core.beans.Apple;
import ps.tutorial.spring.core.beans.ConfigResource;
import ps.tutorial.spring.core.beans.Pear;
import ps.tutorial.spring.core.beans.Tree;

@Configuration
@ComponentScan(basePackages = "ps.tutorial.spring.core.controllers")
public class Context {

    @Bean
    public Apple apple() {
        return new Apple();
    }

    @Bean
    public Pear pear() {
        return new Pear();
    }

    @Bean
    public Pear pearAnother() {
        return new Pear();
    }

    @Bean
    public Tree tree() {
        return new Tree(apple(), pear());
    }

    @Bean
    public Tree treeAnother(Apple apple, @Qualifier("pearAnother")Pear pear) {
        return new Tree(apple, pear);
    }

    @Bean @Scope("prototype")
    public ConfigResource logConfig(@Value("classpath:log4j.xml")Resource config) {
        return new ConfigResource(config);
    }

    @Bean @Scope("prototype")
    public ConfigResource webConfig(@Value("WEB-INF/web.xml")Resource config) {
        return new ConfigResource(config);
    }

}
