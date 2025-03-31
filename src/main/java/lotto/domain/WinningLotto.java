package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final LottoTicket ticket;
    private final LottoNumber bonus;

    public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
        this.ticket = new LottoTicket(winningNumbers);
        this.bonus = new LottoNumber(bonusNumber);
    }

    public boolean matchTicket(LottoNumber number) {
        return ticket.match(number);
    }

    public boolean matchBonus(LottoNumber number) {
        return bonus.equals(number);
    }
}
