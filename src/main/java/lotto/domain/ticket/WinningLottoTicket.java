package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;

public class WinningLottoTicket extends LottoTicket {

    private LottoNumber bonusNumber;

    private WinningLottoTicket(final LottoNumbers numbers, final LottoNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket valueOf(final String winningNumbers, final int bonusNumber) {
        LottoNumbers lottoNumbers = LottoNumbers.of(winningNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);

        return new WinningLottoTicket(lottoNumbers, bonusLottoNumber);
    }
}
