package lottery;

public class DrawResult {
    public final LotteryRow winningRow;
    public final LotteryNumber bonus;

    public DrawResult(LotteryRow winningRow, LotteryNumber bonus) {
        this.winningRow = winningRow;
        this.bonus = bonus;
    }
}
