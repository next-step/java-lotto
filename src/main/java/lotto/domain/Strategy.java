package lotto.domain;

import lotto.exception.InvalidLottoNumber;

public interface Strategy {

    Integer generateNumber();

    default void verifyNumber(int number) {
        if (number < LottoNumber.MIN_NUMBER || number > LottoNumber.MAX_NUMBER) {
            throw new InvalidLottoNumber(String.format("%s %d", InvalidLottoNumber.INVALID_LOTTO_NUMBER, number));
        }
    }
}
