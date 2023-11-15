package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private List<LottoNumber> numbers;

    public LottoNumbers() {
        this.numbers = new ArrayList<>();
    }

    public void add(LottoNumber number) {
        numbers.add(number);
    }
}
