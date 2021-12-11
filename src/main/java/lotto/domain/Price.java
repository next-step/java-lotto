package lotto.domain;

import lotto.exception.InputValueException;

public class Price {

    private static final String MESSAGE_ERR_PRICE = "구매 금액을 확인하세요.";
    private static final long LOTTO_PRICE = 1000L;
    private static final int ZERO_LOTTO = 0;

    private final long price;

    private Price(String price) {
        try {
            this.price = Long.parseLong(price);
        } catch (InputValueException e) {
            throw new InputValueException(MESSAGE_ERR_PRICE);
        }
    }

    public static Price of(String price) {
        return new Price(price);
    }

    public Number calculatorLotto(Number lottoCount) {
        int autoCount = (int) ( price / LOTTO_PRICE) - lottoCount.getNumber();
        if (autoCount >= ZERO_LOTTO) {
            return Number.of(autoCount);
        }
        throw new InputValueException(MESSAGE_ERR_PRICE);
    }
}
