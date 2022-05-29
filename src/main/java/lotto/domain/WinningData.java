package lotto.domain;

public class WinningData {
    private static final int CORRECT = 1;
    private static final int NOT_CORRECT = 0;

    private WinningNumbers winningNumbers;
    private int bonusNumber;

    public WinningData(WinningNumbers winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Rank matchNumbers(LotteryGame lotteryGame) {
        int countOfMatch = 0;
        for (Integer winningNumber : winningNumbers.getWinningNumberList()) {
            countOfMatch += countMatchedNumbers(lotteryGame, winningNumber);
        }
        return Rank.valueOf(countOfMatch, lotteryGame.isContain(bonusNumber));
    }

    private int countMatchedNumbers(LotteryGame lotteryGame, Integer winningNumber) {
        if (lotteryGame.isContain(winningNumber)) {
            return CORRECT;
        }
        return NOT_CORRECT;
    }
}
