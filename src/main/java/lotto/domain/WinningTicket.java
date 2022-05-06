package lotto.domain;

import lotto.exception.InvalidBonusNumberException;

public class WinningTicket {

    private final LottoTicket lottoTicket;
    private final LottoNumber bonusNumber;

    public WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        this.lottoTicket = lottoTicket;
        validBonusNumber(lottoTicket, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    public boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }

    private void validBonusNumber(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.getLottoNumbers().contains(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }
    }

}
