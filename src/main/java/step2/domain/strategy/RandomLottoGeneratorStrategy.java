package step2.domain.strategy;

import step2.domain.Constants;

import java.util.Random;

public class RandomLottoGeneratorStrategy implements LottoGeneratorStrategy {
    private Random random = new Random();

    @Override
    public int getLottoNumber() {
        return random.nextInt(Constants.LOTTO_NUMBER_RANGE_MAX) + 1;
    }
}
