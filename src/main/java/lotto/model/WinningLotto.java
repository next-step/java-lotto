package lotto.model;

public class WinningLotto {

    Lotto lotto;

    LottoBall bonusBall;

    public WinningLotto(Lotto lotto, LottoBall bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public boolean hasBonusBall(Lotto lotto) {
        return lotto.hasLottoBall(this.bonusBall);
    }

    public boolean hasLottoBall(LottoBall lottoBall) {
        return this.lotto.hasLottoBall(lottoBall);
    }
}
