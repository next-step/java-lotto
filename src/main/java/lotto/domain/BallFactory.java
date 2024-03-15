package lotto.domain;

import java.util.Random;

public class BallFactory {

    private static final Random random = new Random();
    private static final int LOWER_BOUND = 1;
    private static final int UPPER_BOUND = 45;

    public static Ball generate() {
        int number = random.nextInt(UPPER_BOUND) + LOWER_BOUND;
        return new Ball(number);
    }
}
