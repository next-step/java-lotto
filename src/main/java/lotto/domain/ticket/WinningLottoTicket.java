package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;

public class WinningLottoTicket {

    private final LottoTicket ticket;

    private WinningLottoTicket(final LottoTicket ticket) {
        this.ticket = ticket;
    }

    public static WinningLottoTicket of(final String winningNumbers) {
        return new WinningLottoTicket(LottoTicket.of(winningNumbers));
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.ticket.contains(lottoNumber);
    }
}
