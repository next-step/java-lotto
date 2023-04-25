package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> value() {
        return this.numbers;
    }
}
