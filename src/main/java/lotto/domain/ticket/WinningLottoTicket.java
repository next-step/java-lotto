package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

public class WinningLottoTicket {

    private final LottoNumbers ticket;

    private WinningLottoTicket(final LottoNumbers ticket) {
        this.ticket = ticket;
    }

    public static WinningLottoTicket of(final String winningNumbers) {
        return new WinningLottoTicket(LottoNumbers.of(winningNumbers));
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.ticket.contains(lottoNumber);
    }
}
