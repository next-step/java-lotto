package lotto.util;

import lotto.domain.LottoNumber;

import java.util.Random;

public class RandomLottoGenerator implements LottoGenerator {
    private static final Random RANDOM = new Random();

    @Override
    public int generatorNumber() {
        return RANDOM.nextInt(LottoNumber.MAX_LOTTO_NUM - 1) + 1;
    }
}
