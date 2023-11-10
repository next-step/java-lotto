package me.namuhuchutong.lotto;

import java.util.Random;

public class RandomNumberGenerator implements NumberGenerator {

    private static final Random RANDOM = new Random();

    @Override
    public int createNumber() {
        return (RANDOM.nextInt(45)) + 1;
    }
}
