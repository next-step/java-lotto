package lotto.domain.ticket;

import lotto.domain.number.LottoNumbers;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final LottoNumbers numbers) {
        super(numbers);
    }

    public static WinningLottoTicket of(final String winningNumbers) {
        return new WinningLottoTicket(LottoNumbers.of(winningNumbers));
    }
}
