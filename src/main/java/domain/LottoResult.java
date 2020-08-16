package domain;

public class LottoResult {
    private final Prize prize;
    private final WinningCount winningCount;

    public LottoResult(Prize prize, int winningNumber) {
        this.prize = prize;
        this.winningCount = new WinningCount(winningNumber);
    }

    public int calculateWinningMoney() {
        return winningCount.calculateWinningMoney(prize.getMoney());
    }

    public void winning(long hitNumber) {
        if (prize.getHitNumber() != hitNumber) {
            return;
        }

        this.winningCount.increase();
    }

    public int getWinningCount() {
        return winningCount.getValue();
    }

    public int getPrizeHitNumber() {
        return prize.getHitNumber();
    }

    public int getPrizeMoney() {
        return prize.getMoney();
    }
}
