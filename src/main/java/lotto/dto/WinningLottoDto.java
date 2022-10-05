package lotto.dto;

public class WinningLottoDto {
    private final String winningNumbers;
    private final int bonusNumber;

    public WinningLottoDto(String winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public String winningNumbers() {
        return winningNumbers;
    }

    public int bonusNumber() {
        return bonusNumber;
    }
}
