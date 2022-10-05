package lotto.domain;

import lotto.strategy.NumberGenerateStrategy;

public class LottoShop {

    private final int LOTTO_PRICE = 1000;

    public int lottoTryCount(int money) {
        return money / LOTTO_PRICE;
    }

    public Lotto createLotto(NumberGenerateStrategy numberGenerateStrategy) {
        return new Lotto(numberGenerateStrategy.generateNumbers());
    }

}

