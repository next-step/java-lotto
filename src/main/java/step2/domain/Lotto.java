package step2.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> numbers() {
        return this.lottoNumbers.numbers();
    }

    public int numberOfMatches(LottoNumbers lottoNumbers) {
        return this.lottoNumbers.numberOfMatches(lottoNumbers);
    }

    public boolean isContain(LottoNumber number) {
        return this.lottoNumbers.contain(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
