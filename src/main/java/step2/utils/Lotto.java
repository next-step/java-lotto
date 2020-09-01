package step2.utils;

import step2.domain.LottoNumbers;

import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers(RandomIntegerGenerator.getRandomInteger());
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

    }

    public LottoNumbers getLotto() {
        return this.lottoNumbers;
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
