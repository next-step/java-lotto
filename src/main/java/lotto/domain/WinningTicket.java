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

    public boolean isMatchBonusNumber(LottoNumber bonusNumber) {
        return this.bonusNumber.equals(bonusNumber);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int count = this.lottoTicket.countMatchNumbers(lottoTicket);
        boolean isMatchBonusNumber = lottoTicket.includeBonusNumber(this.bonusNumber);
        return Rank.getRank(count, isMatchBonusNumber);
    }

    private void validBonusNumber(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.getLottoNumbers().contains(bonusNumber)) {
            throw new InvalidBonusNumberException();
        }
    }

}
