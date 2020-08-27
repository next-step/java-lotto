package lotto.domain;

import java.util.Collections;
import java.util.List;

public class WinningNumber {

    private LottoTicket winningNumbers;
    private int bonusNumber;

    public WinningNumber(LottoTicket winningNumbers, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean isContainsBonusNumber() {
        return winningNumbers.getLottoTicket().contains(bonusNumber);
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumbers.getLottoTicket());
    }

}
