package lotto;

import java.util.Random;

public class BallFactory {

    private static final Random random = new Random();

    public static Ball generate() {
        int number = random.nextInt(45) + 1;
        return new Ball(number);
    }
}
