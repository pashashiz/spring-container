package ps.tutorial.spring.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;
import ps.tutorial.spring.core.beans.Apple;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:context.xml", "classpath:test-context.xml"})
public class ApplicationTest {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    Apple apple;

    @Autowired @Qualifier("appleTest")
    Apple appleTest;

    @Test
    public void testBeans() {
        log.debug("Apple: " + apple);
        log.debug("Apple test: " + appleTest);
        Assert.notNull(apple);
        Assert.notNull(appleTest);
    }

}
