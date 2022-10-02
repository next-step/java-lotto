package lotto.model;

public class WinningLotto {

    Lotto lotto;

    LottoBall bonusBall;

    public WinningLotto(Lotto lotto, LottoBall bonusBall) {
        this.lotto = lotto;
        if (lotto.hasLottoBall(bonusBall)){
            throw new IllegalArgumentException("당첨번호에 보너스볼이 또 존재할수는 없습니다.");
        }
        this.bonusBall = bonusBall;
    }

    public boolean hasBonusBall(Lotto lotto) {
        return lotto.hasLottoBall(this.bonusBall);
    }

    public boolean hasLottoBall(LottoBall lottoBall) {
        return this.lotto.hasLottoBall(lottoBall);
    }
}
