package lotto.domain.strategy;

import java.util.Random;

public class RandomGenerateStrategy implements GenerateStrategy {

    private static RandomGenerateStrategy randomGenerateStrategy = null;

    private RandomGenerateStrategy() {
    }

    public static RandomGenerateStrategy getInstance() {
        if (randomGenerateStrategy == null) {
            randomGenerateStrategy = new RandomGenerateStrategy();
        }
        return randomGenerateStrategy;
    }

    @Override
    public int generateNumber(int min, int max) {

        return new Random().nextInt(max) + min;
    }
}
