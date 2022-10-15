package lotto.random;

import java.util.Random;
import lotto.domain.LottoNumber;

public class RandomLottoNumberGenerator {

    private static final Random random = new Random();
    private static final int BOUND = 45;

    private RandomLottoNumberGenerator() {
    }

    public static LottoNumber generate() {
        return new LottoNumber(random.nextInt(BOUND) + 1);
    }
}
