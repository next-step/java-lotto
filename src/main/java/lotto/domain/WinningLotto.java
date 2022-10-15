package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoBall lottoBall;

    public static WinningLotto of(Lotto lotto, LottoBall bonusBall) {
        if (lotto.hasLottoBall(bonusBall)) {
            throw new IllegalArgumentException("보너스볼은 당첨번호와 중복될 수 없습니다.");
        }
        return new WinningLotto(lotto, bonusBall);
    }

    private WinningLotto(Lotto lotto, LottoBall lottoBall) {
        this.lotto = lotto;
        this.lottoBall = lottoBall;
    }

    public WinningResult retrieveWinnerResult(Lotto lotto) {
        int correctCount = this.lotto.retrieveWinnerLottoBallCount(lotto);
        boolean bonusMatch = lotto.hasLottoBall(this.lottoBall);
        return new WinningResult(correctCount, bonusMatch);
    }
}
