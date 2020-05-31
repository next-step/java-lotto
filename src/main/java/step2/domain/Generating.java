package step2.domain;

public class Generating {

    private GenerableStrategy generableStrategy;

    public Lotto generate(int count) {
        return generableStrategy.generate(count);
    }

    public Generating(GenerableStrategy generableStrategy) {
        if (generableStrategy == null) {
            throw new IllegalArgumentException("generableStrategy cannot be null");
        }
        this.generableStrategy = generableStrategy;
    }
}
