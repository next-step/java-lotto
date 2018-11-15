package domain;

public class WinningNumber {

    private final Lotto toWin;
    private final LottoNumber bonus;

    public WinningNumber(Lotto toWin, LottoNumber bonus) {
        this.toWin = toWin;
        this.bonus = bonus;
    }

    public Prize match(Lotto lotto) {
        return Prize.matchPrize(
            lotto.match(toWin),
            lotto.contains(bonus));
    }
}
