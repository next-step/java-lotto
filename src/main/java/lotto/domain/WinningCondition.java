package lotto.domain;

import java.util.List;

public class WinningCondition {

    private LottoTicket winningTicket;
    private LottoNumber bonusNumber;

    public WinningCondition (List<Integer> winningNumbers, int bonusNumber) {
        this.winningTicket = new LottoTicket(winningNumbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public static WinningCondition of(List<Integer> winningNumbers, int bonusNumber) {
        return new WinningCondition(winningNumbers, bonusNumber);
    }

    public List<Integer> getWinningNumbers() {
        return winningTicket.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.toInt();
    }
}
