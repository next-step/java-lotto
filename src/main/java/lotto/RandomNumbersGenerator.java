package lotto;

import java.util.List;

public final class RandomNumbersGenerator implements NumbersGenerator {

    private static final RandomNumbersGenerator INSTANCE = new RandomNumbersGenerator();

    private RandomNumbersGenerator() {
    }

    public static RandomNumbersGenerator getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Integer> generate() {
        return null;
    }
}
