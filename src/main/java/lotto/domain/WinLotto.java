package lotto.domain;

import java.util.List;

public class WinLotto {

    private final LottoTicket ticket;
    private final LottoNumber bonusNumber;

    public WinLotto(List<Integer> winningTicket, Integer bonusNumber) {
        this(LottoTicket.createTicket(winningTicket), LottoNumber.from(bonusNumber));
    }

    public WinLotto(LottoTicket ticket, LottoNumber bonusNumber) {
        isBonusIncluded(ticket, bonusNumber);
        this.ticket = ticket;
        this.bonusNumber = bonusNumber;
    }

    private static void isBonusIncluded(LottoTicket winningTicket, LottoNumber bonusNumber) {
        if (winningTicket.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스번호는 당첨번호에 포함될 수 없습니다.");
        }
    }

    public LottoPrice price(LottoTicket ticket) {
        return LottoPrice.valueOf(matchNumberCount(ticket),
            matchBonusNumber(ticket));
    }

    private int matchNumberCount(LottoTicket lottoTicket) {
        return (int) lottoTicket.getNumbers().stream().filter(this.ticket.getNumbers()::contains)
            .count();
    }

    private boolean matchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.getNumbers().stream()
            .anyMatch(number -> number.equals(this.bonusNumber));
    }

    public LottoTicket getTicket() {
        return ticket;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
