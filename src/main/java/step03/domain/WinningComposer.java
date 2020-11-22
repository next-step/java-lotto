package step03.domain;

import exception.ExistedInWinningLottoException;

import java.util.Objects;

public class WinningComposer {
    private final Lotto winningLotto;
    private final LottoBall bonusBall;

    private WinningComposer(Lotto winningLotto, LottoBall bonusBall) {
        validateBonusBall(winningLotto, bonusBall);
        this.winningLotto = winningLotto;
        this.bonusBall = bonusBall;
    }

    public static WinningComposer of(Lotto winningLotto, LottoBall bonusBall) {
        return new WinningComposer(winningLotto, bonusBall);
    }

    private static void validateBonusBall(Lotto winningLotto, LottoBall bonusBall) {
        if (winningLotto.isContaining(bonusBall)) {
            throw new ExistedInWinningLottoException();
        }
    }

    public RankCounter calculateMatchOfCount(Lottos lottos) {
         return lottos.calculateCountOfMatch(winningLotto, bonusBall);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningComposer that = (WinningComposer) o;
        return Objects.equals(winningLotto, that.winningLotto) &&
                Objects.equals(bonusBall, that.bonusBall);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusBall);
    }
}
