package domain.lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isWinningLotto(WinningLotto winningLotto) {
        return winningLotto.hasSameNumbersWithSameOrder(this.lottoNumbers);
    }
}
