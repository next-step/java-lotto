package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto createLotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        return new Lotto(lottoGeneratorStrategy.generateLotto());
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public long getWinningCount(WinningNumbers winningNumbers) {
        return winningNumbers.findSameNumber(lotto);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

}
