package ps.tutorial.spring.core.beans;

public class Tree {

    private Apple apple;
    private Pear pear;

    public Tree(Apple apple, Pear pear) {
        this.apple = apple;
        this.pear = pear;
    }

    public Apple getApple() {
        return apple;
    }

    public void setApple(Apple apple) {
        this.apple = apple;
    }

    public Pear getPear() {
        return pear;
    }

    public void setPear(Pear pear) {
        this.pear = pear;
    }

    @Override
    public String toString() {
        return "Tree: {" +
                "apple=" + apple +
                ", pear=" + pear +
                '}';
    }
}
