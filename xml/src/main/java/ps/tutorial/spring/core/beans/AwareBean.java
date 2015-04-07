package ps.tutorial.spring.core.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.instrument.classloading.LoadTimeWeaver;

public class AwareBean implements ApplicationContextAware, BeanClassLoaderAware, BeanFactoryAware,
        BeanNameAware, LoadTimeWeaverAware, ResourceLoaderAware {

    private static Logger log = LoggerFactory.getLogger(AwareBean.class);

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("Application context: {}", applicationContext);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("Class loader: {}", classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("Bean factory: {}", beanFactory);
    }

    @Override
    public void setBeanName(String name) {
        log.info("Bean name: {}", name);
    }

    @Override
    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        log.info("Load time weaver: {}", loadTimeWeaver);
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("Resource loader {}", resourceLoader);
    }

}
