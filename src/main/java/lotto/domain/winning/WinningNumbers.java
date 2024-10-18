package lotto.domain.winning;

import lotto.domain.ticket.LottoNumber;

import java.util.Collections;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumbers(List<Integer> winningNumbers, Integer bonusNumber) {
        this(winningNumbers, new LottoNumber(bonusNumber));
    }

    public WinningNumbers(List<Integer> winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(LottoNumber lottoNumber) {
        return bonusNumber.equals(lottoNumber);
    }

    public List<Integer> getWinningNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

}
