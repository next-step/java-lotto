package lotto.generator;

import lotto.model.Lotto;

import java.util.Random;

public class AutoLottoGeneratorStrategy implements LottoGeneratorStrategy {
    @Override
    public Lotto lottoGenerator() {
        return Lotto.getRandomLotto(new Random());
    }
}
