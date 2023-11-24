package lotto.dto;

import lotto.domain.LottoNumber;
import lotto.domain.Lotto;

public class WinningLottoDTO {
    private Lotto winningLotto;
    private LottoNumber bonus;

    public WinningLottoDTO(Lotto winningNumbers, LottoNumber bonus) {
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
