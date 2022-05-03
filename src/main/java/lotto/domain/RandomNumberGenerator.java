package lotto.domain;

import java.util.Random;

public class RandomNumberGenerator implements GenerateNumberStrategy{

    private static final int MAX_NUMBER = 45;
    private static final Random random = new Random();

    @Override
    public int generate() {
        return random.nextInt(MAX_NUMBER) + 1;
    }
}
