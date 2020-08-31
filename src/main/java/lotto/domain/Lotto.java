package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final long WINNING_CRITERIA = 3L;
    private final List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public static Lotto createLotto(LottoGeneratorStrategy lottoGeneratorStrategy) {
        return new Lotto(lottoGeneratorStrategy.generateLotto());
    }

    public static Lotto createLotto(String[] lottoNumbers) {
        return new Lotto(
                Arrays.stream(lottoNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    public long getWinningCount(WinningNumbers winningNumbers) {
        long count = winningNumbers.findSameNumber(lotto);
        if(count>= WINNING_CRITERIA)
            return count;
        return 0;
    }

    public boolean getBonusMatch(BonusNumber bonusNumber) { return bonusNumber.getBonusMatch(lotto); }
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
