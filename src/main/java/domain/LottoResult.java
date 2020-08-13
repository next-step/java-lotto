package domain;

public class LottoResult {
    private Prize prize;
    private int winningNumber;

    public LottoResult(Prize prize, int winningNumber) {
        this.prize = prize;
        this.winningNumber = winningNumber;
    }

    public int calculateWinningMoney() {
        return prize.getMoney() * winningNumber;
    }

    public void winning(int hitNumber) {
        if(prize.getHitNumber() != hitNumber) {
            return;
        }

        this.winningNumber++;
    }


    public Prize getPrize() {
        return prize;
    }

    public int getWinningNumber() {
        return winningNumber;
    }

    public int getPrizeHitNumber() {
        return prize.getHitNumber();
    }

    public int getPrizeMoney() {
        return prize.getMoney();
    }
}
