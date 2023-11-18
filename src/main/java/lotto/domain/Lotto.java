package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        numbers.validateDigit();
        numbers.validateRange();
        this.numbers = numbers;
    }
}
