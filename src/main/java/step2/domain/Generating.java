package step2.domain;

public class Generating {

    private GenerableStrategy generableStrategy;

    public Lotto generate(int count) {
        return generableStrategy.generate(count);
    }

    public void setGenerableStrategy(GenerableStrategy generableStrategy) {
        this.generableStrategy = generableStrategy;
    }
}
