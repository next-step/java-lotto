package lotto.domain;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusWinningNumber;

    public WinningLotto(Lotto winningLotto, LottoNumber bonusWinningNumber) {
        if(winningLotto.hasSameElement(bonusWinningNumber)){
            throw new IllegalArgumentException("winning numbers cannot have the same number with the bonus number");
        }
        this.winningLotto = winningLotto;
        this.bonusWinningNumber = bonusWinningNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusWinningNumber() {
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
