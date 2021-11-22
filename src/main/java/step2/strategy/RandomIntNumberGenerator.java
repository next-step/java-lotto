package step2.strategy;

import step2.utils.RandomUtils;

public class RandomIntNumberGenerator implements IntNumberGeneratorStrategy {

    @Override
    public int generate() {
        return RandomUtils.nextInt();
    }
}
