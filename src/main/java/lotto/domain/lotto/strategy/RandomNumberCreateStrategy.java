package lotto.domain.lotto.strategy;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.strategy.LottoNumberCreateStrategy;

import java.util.Random;

public class RandomNumberCreateStrategy implements LottoNumberCreateStrategy {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    public LottoNumber create() {
        final int max = LottoNumber.MAX.getValue();
        final int min = LottoNumber.MIN.getValue();
        final int randomNumber = RANDOM.nextInt(max) + min;
        return LottoNumber.of(randomNumber);
    }
}
