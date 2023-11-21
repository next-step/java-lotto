package lotto.domain;

import java.util.List;
import java.util.function.Predicate;

public class Lotto {

    private final LottoNumber lottoNumber;

    public Lotto(List<Integer> numbers) {
        lottoNumber = new LottoNumber(numbers);
    }

    public Lotto() {
        lottoNumber = new LottoNumber();
    }

    public List<Integer> getNumbers() {
        return lottoNumber.getNumbers();
    }
}
