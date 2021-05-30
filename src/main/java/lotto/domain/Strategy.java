package lotto.domain;

import lotto.exception.InvalidLottoNumber;

import java.util.Set;

public interface Strategy {
    int MIN_NUMBER = 1;
    int MAX_NUMBER = 45;
    int GENERATE_NUMBER_COUNT = 6;
    Set<Integer> generateNumbers();
    Integer generateNumber();
    default void verifyNumber(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new InvalidLottoNumber(String.format("%s %d", InvalidLottoNumber.INVALID_LOTTO_NUMBER, number));
        }
    }
}
