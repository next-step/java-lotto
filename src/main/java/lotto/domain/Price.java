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
            valid();
        } catch (InputValueException e) {
            throw new InputValueException(MESSAGE_ERR_PRICE);
        }
    }

    public static Price of(String price) {
        return new Price(price);
    }

    public LottoCount calculatorLottoCount(LottoCount lottoCount) {
        int autoCount = (int) ( price / LOTTO_PRICE) - lottoCount.getCount();
        if (autoCount >= ZERO_LOTTO) {
            return LottoCount.of(autoCount);
        }
        throw new InputValueException(MESSAGE_ERR_PRICE);
    }

    private void valid() {
        if (price < 0) {
            throw new InputValueException(MESSAGE_ERR_PRICE);
        }
    }
}
