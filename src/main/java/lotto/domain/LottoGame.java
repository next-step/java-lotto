package lotto.domain;

import lotto.strategy.LottoStrategy;

public class LottoGame {

    private static final int LOTTO_PRICE = 1000;

    private static final String LOTTO_PRICE_ERROR_MESSAGE = "로또 구입 금액은 1000원 이상이어야 합니다.";

    private final int gameCount;

    public LottoGame(final int buyMoney) {
        validate(buyMoney);
        gameCount = calcGameCount(buyMoney);
    }

    private void validate(final int buyMoney) {
        if (buyMoney < LOTTO_PRICE) {
            throw new IllegalArgumentException(LOTTO_PRICE_ERROR_MESSAGE);
        }
    }

    private static int calcGameCount(final int buyMoney) {
        return buyMoney / LOTTO_PRICE;
    }

    public Lottos automaticLottoDraw(final LottoStrategy lottoStrategy) {
        return new Lottos(lottoStrategy, gameCount);
    }

}
