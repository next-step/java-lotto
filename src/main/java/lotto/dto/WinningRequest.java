package lotto.dto;

public class WinningRequest {

    private final String winningNumbers;

    private final String bonusNumbers;

    public WinningRequest(final String winningNumbers, final String bonusNumbers) {
        this.winningNumbers = winningNumbers;
        this.bonusNumbers = bonusNumbers;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public String getBonusNumbers() {
        return bonusNumbers;
    }
}
