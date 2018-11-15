package domain;

public class WinningNumber {

    private final Lotto toWin;
    private final LottoNumber bonus;

    public WinningNumber(Lotto toWin, LottoNumber bonus) {
        this.toWin = toWin;
        this.bonus = bonus;
    }

    public int matched(Lotto lotto) {
        return lotto.match(toWin);
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.contains(bonus);
    }
}
