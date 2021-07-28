package lotto.domain;

import lotto.exception.OutOfSizeException;

import java.util.Set;

public class Lotto {
    private final Set<LottoNumber> values;

    private static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto(Set<LottoNumber> numbers) {
        this.values = numbers;

        validValues();
    }

    private void validValues() {
        if (values.size() != LOTTO_NUMBER_SIZE) {
            throw new OutOfSizeException("로또 번호가 6개가 아닙니다.");
        }
    }
}
