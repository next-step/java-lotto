package lotto.domain;

import java.util.List;

public class LottoNumber {

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
