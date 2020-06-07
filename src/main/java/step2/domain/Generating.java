package step2.domain;

import static step2.view.ErrorMessages.INVALID_PARAMETER_GENERABLE_STRATEGY;

import java.util.List;

public class Generating {

    private GenerableStrategy generableStrategy;

    public List<Integer> generate(int count) {
        return generableStrategy.generate(count);
    }

    public Generating(GenerableStrategy generableStrategy) {
        if (generableStrategy == null) {
            throw new IllegalArgumentException(INVALID_PARAMETER_GENERABLE_STRATEGY);
        }
        this.generableStrategy = generableStrategy;
    }
}
