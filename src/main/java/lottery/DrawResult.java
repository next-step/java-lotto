package lottery;

public class DrawResult {
    public final LotteryRow winningRow;
    public final LotteryNumber bonus;

    public DrawResult(LotteryRow winningRow, LotteryNumber bonus) {
        checkNoBonusInWinningRow(winningRow, bonus);
        this.winningRow = winningRow;
        this.bonus = bonus;
    }

    private void checkNoBonusInWinningRow(LotteryRow winningRow, LotteryNumber bonus) {
        if (winningRow.isBonusHit(bonus)) {
            throw new IllegalArgumentException("Winning row contains bonus");
        }
    }
}
