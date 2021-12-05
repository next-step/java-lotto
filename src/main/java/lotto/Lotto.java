package lotto;

import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto() {
        this.lottoNumbers = new LottoNumbers();
    }

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers lottoNumbers() {
        return this.lottoNumbers;
    }

    public boolean result(LottoNumbers winningNumbers, Condition condition) {
        return lottoNumbers.result(winningNumbers, condition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
