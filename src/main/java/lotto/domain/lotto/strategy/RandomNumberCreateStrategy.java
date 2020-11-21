package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;

import java.util.Random;

public class RandomNumberCreateStrategy implements LottoNumberCreateStrategy {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public LottoNumber create() {
        final int randomNumber = RANDOM.nextInt(LottoNumber.MAX_NO) + LottoNumber.MIN_NO;
        return LottoNumber.of(randomNumber);
    }
}
