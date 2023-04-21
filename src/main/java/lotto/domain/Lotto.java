package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoStrategy lottoStrategy) {
        this.lottoNumbers = new LottoNumbers(lottoStrategy);
    }

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }


    public static Lotto winningLotto(String numbers) {
        return new Lotto(LottoNumbers.winningNumbers(numbers));
    }

    public int statCount(Lotto lotto) {
        return this.lottoNumbers.statCount(lotto.lottoNumbers);
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
