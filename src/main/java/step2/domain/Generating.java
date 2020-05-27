package step2.domain;

import java.util.List;

public class Generating {

    private GenerableStrategy generableStrategy;

    public List<Integer> generate(int count) {
        return generableStrategy.generate(count);
    }

    public void setGenerableStrategy(GenerableStrategy generableStrategy) {
        this.generableStrategy = generableStrategy;
    }
}
