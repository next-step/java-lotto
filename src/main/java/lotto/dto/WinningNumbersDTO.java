package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;

public class WinningNumbersDTO {
    private Lotto winningLotto;
    private LottoNumber bonus;

    public WinningNumbersDTO(Lotto winningNumbers, LottoNumber bonus) {
        this.winningLotto = winningNumbers;
        this.bonus = bonus;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonus() {
        return bonus;
    }
}
