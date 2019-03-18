package lotto;

import java.util.Random;

public class LottoRandomNumberGenerator {
    public static final int BOUND = 45;
    private static Random random = new Random();

    public static int next() {
        return random.nextInt(BOUND) + 1;
    }
}
