package lotto.domain;

import lotto.exception.InvalidInputException;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String INVALID_WINNING_NUMBERS = "유효하지 않은 번호를 입력하셨습니다.";
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    private int number;

    public LottoNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number > MAX_NUMBER || number < MIN_NUMBER) {
            throw new InvalidInputException(INVALID_WINNING_NUMBERS);
        }
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int compareTo(LottoNumber n) {
        return this.number - n.getNumber();
    }

    @Override
    public String toString() {
        return String.valueOf(getNumber());
    }
}