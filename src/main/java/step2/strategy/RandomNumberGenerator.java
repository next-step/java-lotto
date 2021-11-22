package step2.strategy;

import step2.utils.RandomUtils;

public class RandomNumberGenerator implements NumberGeneratorStrategy {

    @Override
    public int generate() {
        return RandomUtils.nextInt();
    }
}
