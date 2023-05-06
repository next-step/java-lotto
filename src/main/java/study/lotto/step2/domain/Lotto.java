package study.lotto.step2.domain;

import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(Integer... lottoNumbers) {
        this(new LottoNumbers(lottoNumbers));
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.getLottoNumbers().toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
