package lottery;

import java.util.Set;

public class DrawResult {
    public final LotteryRow winningRow;
    public final LotteryNumber bonus;

    private DrawResult(LotteryRow winningRow, LotteryNumber bonus) {
        this.winningRow = winningRow;
        this.bonus = bonus;
    }

    public static DrawResult fromWinningNumbersAndBonus(Set<Integer> winningNumbers, Integer bonus) {
        return new DrawResult(LotteryRow.fromGiven(winningNumbers), LotteryNumber.fromGiven(bonus));
    }
}
