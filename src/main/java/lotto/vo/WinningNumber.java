package lotto.vo;


public class WinningNumber {
    Lottery winningNumbers;

    public WinningNumber(Lottery winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Rank match(Lottery userLotto) {
        int matchCount = winningNumbers.containsCount(userLotto);
        return Rank.valueOf(matchCount);
    }
}
