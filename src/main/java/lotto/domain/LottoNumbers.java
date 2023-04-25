package lotto.domain;

import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBERS_SIZE = 6;

    private final List<LottoNumber> numbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new RuntimeException("로또 번호의 개수는 6개여야 합니다.");
        }
        this.numbers = numbers;
    }

    public List<LottoNumber> value() {
        return this.numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
