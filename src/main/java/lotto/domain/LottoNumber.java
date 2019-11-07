package lotto.domain;

import java.util.List;

public class LottoNumber {

    private int number;

    LottoNumber(int number) {
        this.number = number;
    }

    boolean hasMatchedNumber(List<Integer> numbers) {
        for (Integer lottoNumber : numbers) {
            if (lottoNumber == number) {
                return true;
            }
        }
        return false;
    }

    int getValue() {
        return number;
    }
}
