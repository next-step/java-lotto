package lotto.domain;

public class LottoShop {
    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_MONEY_BOUND = 0;
    private static final String INVALID_LOTTO_MONEY_MESSAGE = "적절한 금액이 아닙니다.";

    public static Lottos sellLotto(int money) {
        if (money < MIN_MONEY_BOUND) {
            throw new IllegalArgumentException(INVALID_LOTTO_MONEY_MESSAGE);
        }

        int lottoQuantity = money / LOTTO_PRICE;
        return LottosFactory.createAuto(lottoQuantity);
    }
}
