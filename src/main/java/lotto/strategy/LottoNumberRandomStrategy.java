package lotto.strategy;

import lotto.domain.LottoNumber;

import java.util.Random;

public class LottoNumberRandomStrategy implements LottoNumberStrategy {

    private static final Random RANDOM = new Random();
    private static final int RANDOM_BOUND_NUMBER = 45;

    @Override
    public LottoNumber generate() {
        return new LottoNumber(RANDOM.nextInt(RANDOM_BOUND_NUMBER) + 1);
    }
}
