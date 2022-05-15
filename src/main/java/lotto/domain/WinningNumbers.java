package lotto.domain;

public class WinningNumbers {
    public static final int WINNING_MINIMUM = 3;

    private Lotto winningNumbers;
    private Winners winners;

    public WinningNumbers(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
        winners = new Winners();
    }

    public void findWinners(Lotto lotto) {
        int count = winningNumbers.numberOfSame(lotto);
        if (count >= WINNING_MINIMUM) {
            winners.addWinner(count);
        }
    }

    public boolean isWinners(Winners winners) {
        return this.winners.equals(winners);
    }

    public double revenue(int money) {
        return this.winners.revenue(money);
    }

    public String isBenefit(double revenue) {
        if (revenue > 1) {
            return "이득";
        }
        if (revenue < 1) {
            return "손해";
        }
        return "본전";

    }

    @Override
    public String toString() {
        return winners.toString();
    }
}
