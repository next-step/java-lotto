package lotto.domain;

import lotto.strategy.NumberGenerateStrategy;

public class LottoMachine {

    private static final int LOTTO_PRICE = 1000;

    public static int lottoTryCount(int money) {
        return money / LOTTO_PRICE;
    }

    public static Lotto createLotto(NumberGenerateStrategy numberGenerateStrategy) {
        return new Lotto(numberGenerateStrategy.generateNumbers());
    }

}

