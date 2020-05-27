package step2;

import java.util.List;
import step0.GenerableStrategy;

public class Generating {

    private GenerableStrategy generableStrategy;

    public List<Integer> generate(int count) {
        return generableStrategy.generate(count);
    }

    public void setGenerableStrategy(GenerableStrategy generableStrategy) {
        this.generableStrategy = generableStrategy;
    }
}
