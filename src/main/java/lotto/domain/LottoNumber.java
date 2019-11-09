package lotto.domain;

import java.util.List;

public class LottoNumber {

    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;

    private int number;

    public LottoNumber(int number) {
        this.number = number;
    }

    public boolean hasMatchedNumber(List<Integer> numbers) {
        return numbers
                .stream()
                .anyMatch(number -> this.number == number);
    }

    int getValue() {
        return number;
    }
}
