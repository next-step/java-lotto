package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.exception.ErrorMessage;

import java.util.List;

public class WinningLottoTicket {

    private final LottoNumbers lottoNumbers;
    private final LottoNumber bonusNumber;

    private WinningLottoTicket(final LottoNumbers lottoNumbers, final LottoNumber bonusNumber) {
        verifyDuplication(lottoNumbers, bonusNumber);

        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket valueOf(final List<LottoNumber> winningNumbers, final int bonusNumber) {
        LottoNumbers lottoNumbers = LottoNumbers.manualCreate(winningNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);

        return new WinningLottoTicket(lottoNumbers, bonusLottoNumber);
    }

    private static void verifyDuplication(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
        if (lottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER);
        }
    }

    public boolean contains(final LottoNumber lottoNumber) {
        return this.lottoNumbers.contains(lottoNumber);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
