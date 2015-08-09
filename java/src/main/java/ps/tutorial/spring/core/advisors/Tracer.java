package ps.tutorial.spring.core.advisors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect @Component
public class Tracer {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Pointcut("within(ps.tutorial.spring.core.beans..*)")
    private void beansPackage() {}

    @Before("beansPackage() && execution(public * *(..))")
    public void beforeBeanMethod(JoinPoint jp) {
        log.debug("Before bean: " + jp);
    }

    @After("beansPackage() && execution(public * *(..))")
    public void afterBeanMethod(JoinPoint jp) {
        log.debug("After bean: " + jp);
    }

}
