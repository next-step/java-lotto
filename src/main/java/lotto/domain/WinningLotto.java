package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusWinningNumber;

    public WinningLotto(Lotto winningLotto, Integer bonusWinningNumber) {
        this.winningLotto = winningLotto;
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusWinningNumber() {
        return bonusWinningNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusWinningNumber, that.bonusWinningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusWinningNumber);
    }
}
