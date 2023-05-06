package lotto.domain;

import lotto.exception.LimitRangeRuleViolateException;

public class NumberStrategySequential implements NumberStrategy {
    private static final NumberStrategySequential numberStrategySequential = new NumberStrategySequential();
    private int seed;

    private NumberStrategySequential() {
        seed = 0;
    }

    public static NumberStrategySequential of() {
        return numberStrategySequential;
    }

    @Override
    public int generate(int lowLimit, int highLimit) {
        validateLimit(lowLimit, highLimit);
        return (seed++ % (highLimit - lowLimit)) + lowLimit;
    }

    @Override
    public void validateLimit(int lowLimit, int highLimit) {
        if (lowLimit > highLimit) {
            throw new LimitRangeRuleViolateException();
        }
    }
}
