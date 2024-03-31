package lotto.domain;

import java.util.List;

public class WinLotto {

    private final LottoTicket ticket;
    private final LottoNumber bonusNumber;

    public WinLotto(List<Integer> winningTicket, Integer bonusNumber) {
        isBonusIncluded(winningTicket, bonusNumber);
        this.ticket = LottoTicket.createTicket(winningTicket);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private static void isBonusIncluded(List<Integer> winningTicket, Integer bonusNumber) {
        if (winningTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에 포함될 수 없습니다.");
        }
    }

    public LottoTicket getTicket() {
        return ticket;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
