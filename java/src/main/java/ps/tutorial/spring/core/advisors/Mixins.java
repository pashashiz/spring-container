package ps.tutorial.spring.core.advisors;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;
import ps.tutorial.spring.core.beans.Fruit;

@Aspect @Component
public class Mixins {

    @DeclareParents(value = "ps.tutorial.spring.core.beans.Apple", defaultImpl = EcoFruit.class)
    public Fruit fruitMixin;

    public static class EcoFruit implements Fruit {

        @Override
        public boolean isEcoFriendly() {
            return true;
        }

    }

}
