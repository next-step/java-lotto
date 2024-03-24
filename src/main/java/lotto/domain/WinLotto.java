package lotto.domain;

import lotto.exception.AlreadyExistLottoNumberException;

public class WinLotto {

    private final LottoTicket winLotto;
    private final LottoNumber bonusNumber;

    public WinLotto(LottoTicket winLotto, LottoNumber bonusNumber) {
        validateAlreadyExistLottoNumber(winLotto, bonusNumber);
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateAlreadyExistLottoNumber(LottoTicket winLotto, LottoNumber bonusNumber) throws AlreadyExistLottoNumberException {
        if (winLotto.contains(bonusNumber)) {
            throw new AlreadyExistLottoNumberException(winLotto.get(), bonusNumber);
        }
    }

    public LottoTicket getWinLotto() {
        return winLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
