package ps.tutorial.spring.core;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ps.tutorial.spring.core.beans.Apple;
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

}
