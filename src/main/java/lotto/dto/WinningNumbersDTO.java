package lotto.dto;

public class WinningNumbersDTO {
    private String winningNumbers;
    private String bonusNumber;

    public WinningNumbersDTO(String winningNumbers, String bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }

    public String getBonusNumber() {
        return bonusNumber;
    }
}
