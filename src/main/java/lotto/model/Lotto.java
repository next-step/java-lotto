package lotto.model;

import java.util.LinkedHashSet;
import java.util.Set;

public class Lotto {

    private final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Lotto(Set<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new LinkedHashSet<>();
        for (int number : numbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }
        this.numbers = new LottoNumbers(lottoNumbers);
    }

    public Set<LottoNumber> numbers() {
        return this.numbers.lottoNumbers();
    }

}
