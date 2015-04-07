package ps.tutorial.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

public class Runner {

    private static Logger log = LoggerFactory.getLogger(Runner.class);
    private ApplicationContext context;

    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
    }

    private void start() {
        context = Application.getContext();
    }

}
