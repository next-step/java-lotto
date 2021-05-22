package step3;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;


public class Lotto {

    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void shuffle() {
        Collections.shuffle(lottoNumbers);
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
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

    public void sort() {
        lottoNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
    }
}
