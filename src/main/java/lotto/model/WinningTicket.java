package lotto.model;

import lotto.exception.InvalidBonusNumberException;

public class WinningTicket {

    private final LottoTicket lottoTicket;

    private final LottoNumber bonusNumber;

    public WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        this.lottoTicket = lottoTicket;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int count = this.lottoTicket.countMatches(lottoTicket);
        boolean matchBonus = lottoTicket.includeBonusNumber(bonusNumber);
        return Rank.valueOf(count, matchBonus);
    }

    private void validateBonusNumber(LottoNumber bonusNumber) {
        if(!lottoTicket.includeBonusNumber(bonusNumber)) {
            throw new InvalidBonusNumberException(bonusNumber);
        }
    }

}
