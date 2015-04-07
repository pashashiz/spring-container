package ps.tutorial.spring.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class TracingBeanPostProcessor implements BeanPostProcessor {

    private Logger log = LoggerFactory.getLogger(getClass());

    // simply return the instantiated bean as-is
    public Object postProcessBeforeInitialization(Object bean,
                                                  String beanName) throws BeansException {
        return bean; // we could potentially return any object reference here...
    }

    public Object postProcessAfterInitialization(Object bean,
                                                 String beanName) throws BeansException {
        log.info("Bean [{}] created [{}]", beanName, bean);
        return bean;
    }

}