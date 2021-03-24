package step2;

import java.util.Random;

public class RandomLottoNumberGenerator implements LottoNumberGenerator{
    private static final int RANDOM_BOUND = 45;
    @Override
    public int generator() {
        return new Random().nextInt(RANDOM_BOUND) + 1;
    }
}
