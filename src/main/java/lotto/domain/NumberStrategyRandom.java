package lotto.domain;

import lotto.exception.LimitRangeRuleViolateException;

import java.util.Random;

public class NumberStrategyRandom implements NumberStrategy {
    private static final NumberStrategyRandom NUMBER_STRATEGY_RANDOM = new NumberStrategyRandom();
    private final Random random;

    private NumberStrategyRandom() {
        random = new Random();
    }

    public static NumberStrategy of() {
        return NUMBER_STRATEGY_RANDOM;
    }

    @Override
    public int generate(int lowLimit, int highLimit) {
        validateLimit(lowLimit, highLimit);
        return random.nextInt(highLimit - lowLimit) + lowLimit;
    }

    @Override
    public void validateLimit(int lowLimit, int highLimit) {
        if (lowLimit > highLimit) {
            throw new LimitRangeRuleViolateException();
        }
    }
}
