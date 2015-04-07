package ps.tutorial.spring.core;

import ps.tutorial.spring.core.beans.Tree;
import ps.tutorial.spring.core.beans.Apple;
import ps.tutorial.spring.core.beans.Pear;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class Runner {

    private static Logger log = LoggerFactory.getLogger(Runner.class);
    private ApplicationContext context;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        //runner.plainBeans();
    }

    private void start() {
        context = Application.getContext();
    }

    public void plainBeans() {
        log.info("Before getting beans");
        Apple apple = context.getBean("apple", Apple.class);
        Pear pear = context.getBean("pear", Pear.class);
        log.info("Simple beans: {Apple: {}, Pear: {}}", apple, pear);
        Tree tree = context.getBean("tree", Tree.class);
        log.info("Singleton tree: {}", tree);
    }

}
