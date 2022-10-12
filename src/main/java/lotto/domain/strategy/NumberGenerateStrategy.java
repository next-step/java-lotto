package lotto.domain.strategy;

import java.util.List;

public enum NumberGenerateStrategy {
    RANDOM(new RandomNumberGenerator());
    
    private final NumberGeneratable generator;

    NumberGenerateStrategy(NumberGeneratable generator) {
        this.generator = generator;
    }

    public List<Integer> createNumbers() {
        return generator.generate();
    }
}
