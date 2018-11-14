package lotto.domain;

import java.util.List;

public class WinningLotto {

    private Ticket winningTicket;
    private LottoNo bonus;

    public WinningLotto(List<LottoNo> winningNumbers, LottoNo bonus) {
        this.winningTicket = new Ticket(winningNumbers);
        this.bonus = bonus;
        LottoValidator.validate(winningNumbers);
        LottoValidator.validate(bonus);
    }

    public List<LottoNo> winningLottoStatus() {
        return this.winningTicket.getNumbers();
    }

    public LottoNo findBonus() {
        return this.bonus;
    }
}
