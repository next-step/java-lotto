package lotto.domain;

import java.util.Random;

public class BallFactory {

    private static final Random random = new Random();

    private BallFactory() {

    }

    public static Ball generate() {
        int number = random.nextInt(Ball.UPPER_BOUND) + Ball.LOWER_BOUND;
        return new Ball(number);
    }
}
