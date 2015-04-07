package ps.tutorial.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Application {

    private static ApplicationContext context;

    public static ApplicationContext getContext() {
        if (context == null) context = new ClassPathXmlApplicationContext("context.xml");
        return context;
    }

}
