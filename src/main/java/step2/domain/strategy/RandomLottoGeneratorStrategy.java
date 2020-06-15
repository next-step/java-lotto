package step2.domain.strategy;

import step2.domain.Constants;

import java.util.Random;

public class RandomLottoGeneratorStrategy implements LottoNumberGeneratorStrategy {
    private Random random = new Random();

    @Override
    public int generateLottoNumber() {
        return random.nextInt(LOTTO_NUMBER_RANGE_MAX) + 1;
    }
}
