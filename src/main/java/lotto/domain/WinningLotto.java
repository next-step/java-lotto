package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this(new Lotto(lotto), bonusNumber);
    }

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public long match(Lotto lotto) {
        return this.winningLotto.getNumbers().stream().filter(lotto.getNumbers()::contains).count();
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.containBonusNumber(bonusNumber);
    }
}
