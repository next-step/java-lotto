package util;

import domain.LottoNumber;

import java.util.Random;

public class RandomLottoNumberGenerator implements RandomGenerator<LottoNumber> {
    private static final int DEFAULT_BOUND = 45;

    private static final Random random = new Random();

    protected RandomLottoNumberGenerator() { }

    public static RandomLottoNumberGenerator getInstance() {
        return LazyHolder.instance;
    }

    @Override
    public LottoNumber generate() {
        return new LottoNumber(random.nextInt(DEFAULT_BOUND - 1) + 1);
    }

    private static class LazyHolder {
        private static final RandomLottoNumberGenerator instance = new RandomLottoNumberGenerator();
    }
}
