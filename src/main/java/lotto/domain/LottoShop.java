package lotto.domain;

import lotto.domain.exception.InvalidLottoMoneyException;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_MONEY_BOUND = 0;

    public static Lottos sellLotto(int money) {
        if (money < MIN_MONEY_BOUND) {
            throw new InvalidLottoMoneyException("입력한 금액 : ", String.valueOf(money));
        }

        int lottoQuantity = money / LOTTO_PRICE;
        return LottosFactory.createAuto(lottoQuantity);
    }
}
