package step2.domain;

public class Generating {

    private GenerableStrategy generableStrategy;

    public Lotto generate(int count) {
        return generableStrategy.generate(count);
    }

    public Generating(GenerableStrategy generableStrategy) {
        this.generableStrategy = generableStrategy;
    }
}
