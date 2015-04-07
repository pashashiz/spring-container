package ps.tutorial.spring.core.beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class LifeCycleBean {

    private Logger log = LoggerFactory.getLogger(getClass());

    private Tree tree;

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    // Works only if dependency injection is applied for some property in this class!!!
    @PostConstruct
    public void initAnnotated() {
        log.info("Init bean annotated {}", getClass());
    }

    public void init() {
        log.info("Init bean {}", getClass());
    }

    @PreDestroy
    public void destroyAnnotated() {
        log.info("Destroy bean annotated {}", getClass());
    }

    public void destroy() {
        log.info("Init bean {}", getClass());
    }
}
