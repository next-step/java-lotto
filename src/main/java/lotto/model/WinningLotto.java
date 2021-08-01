package lotto.model;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;

    private WinningLotto(final Lotto lotto) {
        this.winningLotto = lotto;
    }

    public static WinningLotto from(final String winningNumber) {
        Objects.requireNonNull(winningNumber, "winningNumbers must be not null.");
        return new WinningLotto(Lotto.from(winningNumber));
    }

    public boolean isSizeValid() {
        return winningLotto.isSizeValid();
    }

    public int matchCount(final Lotto lotto) {
        return winningLotto.matchCount(lotto);
    }
}
