package lotto.domain;

import java.util.Objects;

public class BonusNumber {

    private int number;

    BonusNumber(int number) {
        this.number = number;
    }

    boolean hasMatchedNumber(LottoNumbers lottoNumbers) {
        for (Integer lottoNumber : lottoNumbers.getValue()) {
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
