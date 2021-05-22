package lotto.domain;

import lotto.exception.InvalidLottoNumber;

public interface Number extends Comparable<Number> {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;

    int number();

    default void verifyNumbers(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidLottoNumber(String.format("%s %d", InvalidLottoNumber.INVALID_LOTTO_NUMBER, number));
        }
    }
}
