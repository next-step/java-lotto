package me.namuhuchutong.lotto;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public Number createNumber() {
        return new Number(RANDOM.nextInt(45) + 1);
    }
}
