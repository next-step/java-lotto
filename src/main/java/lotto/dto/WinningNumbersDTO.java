package lotto.dto;

import lotto.domain.BonusNumber;
import lotto.domain.WinningNumber;

public class WinningNumbersDTO {
    private WinningNumber winningNumber;
    private BonusNumber bonusNumber;

    public WinningNumbersDTO(WinningNumber winningNumbers, BonusNumber bonusNumber) {
        this.winningNumber = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public WinningNumber getWinningNumbers() {
        return winningNumber;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
