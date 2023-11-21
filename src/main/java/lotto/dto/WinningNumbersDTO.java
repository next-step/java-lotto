package lotto.dto;

import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class WinningNumbersDTO {
    private Lotto winningLotto;
    private BonusNumber bonusNumber;

    public WinningNumbersDTO(Lotto winningNumbers, BonusNumber bonusNumber) {
        this.winningLotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningNumbers() {
        return winningLotto;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
