package lotto.lotto;

import lotto.lotto.lottonumber.LottoNumbers;

import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    private Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto from(List<Integer> input) {
        LottoNumbers lottoNumbers = LottoNumbers.from(input);
        return new Lotto(lottoNumbers);
    }

    public static Lotto from(LottoNumbers input) {
        return new Lotto(input);
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers.values();
    }

    public boolean match(LottoNumbers winningNumbers, Condition condition) {
        return lottoNumbers.match(winningNumbers, condition);
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
