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

    // 일치하는 수 먼저 검사하고, 보너스볼 당첨 결과를 검사한다. 메서드 분리 /.. 보너스볼은 winningNumbers에 포함되면 안된다.
//    - public NumberCountCollections statisticWinning(Lotto winningNumbers, LottoBall bonusBall)

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
