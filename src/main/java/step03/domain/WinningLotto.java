package step03.domain;

import exception.ExistedInWinningLottoException;

import java.util.Objects;

public class WinningLotto {
    private final Lotto winningLotto;
    private final BonusBall bonusBall;

    private WinningLotto(Lotto winningLotto, BonusBall bonusBall) {
        validateBonusBall(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(Lotto winningLotto, BonusBall bonusBall) {
        return new WinningLotto(winningLotto, bonusBall);
    }

    private static void validateBonusBall(Lotto winningLotto, BonusBall bonusBall) {
//        if (!winningLotto.isContaining(bonusBall)) {
//            throw new ExistedInWinningLottoException();
//        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusBall);
    }
}
