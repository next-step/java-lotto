package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

public class WinningLottoTicket extends LottoTicket {

    private WinningLottoTicket(final LottoNumbers numbers) {
        super(numbers);
    }

    public static WinningLottoTicket of(final String winningNumbers) {
        return new WinningLottoTicket(LottoNumbers.of(winningNumbers));
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return super.contains(lottoNumber);
    }
}
