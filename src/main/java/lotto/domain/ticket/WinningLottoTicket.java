package lotto.domain.ticket;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumbers;
import lotto.exception.ErrorMessage;

import java.util.List;

public class WinningLottoTicket extends LottoTicket {

    private LottoNumber bonusNumber;

    private WinningLottoTicket(final LottoNumbers numbers, final LottoNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLottoTicket valueOf(final List<LottoNumber> winningNumbers, final int bonusNumber) {
        LottoNumbers lottoNumbers = LottoNumbers.manualCreate(winningNumbers);
        LottoNumber bonusLottoNumber = LottoNumber.of(bonusNumber);
        validateDuplication(lottoNumbers, bonusLottoNumber);

        return new WinningLottoTicket(lottoNumbers, bonusLottoNumber);
    }

    private static void validateDuplication(LottoNumbers lottoNumbers, LottoNumber bonusLottoNumber) {
        if (lottoNumbers.contains(bonusLottoNumber)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_BONUS_NUMBER);
        }
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
