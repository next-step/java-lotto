package lotto;

import java.util.Random;

public class LottoNumberGenerator {
    private static Random random = new Random();

    public static int generate(int min, int bound) {
        return random.nextInt(bound) + min;
    }
}
