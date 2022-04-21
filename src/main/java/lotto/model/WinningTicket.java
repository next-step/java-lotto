package lotto.model;

import lotto.exception.InvalidBonusNumberException;

import java.util.Set;

public class WinningTicket {

    private final LottoTicket lottoTicket;

    public WinningTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoTicket = new LottoTicket(lottoNumbers);
    }

    public WinningTicket(LottoTicket lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public Rank getRank(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        int count = this.lottoTicket.countMatches(lottoTicket);
        boolean matchBonus = lottoTicket.includeBonusNumber(bonusNumber);
        return Rank.valueOf(count, matchBonus);
    }

    public void validateBonusNumber(LottoNumber bonusNumber) {
        if(!lottoTicket.includeBonusNumber(bonusNumber)) {
            throw new InvalidBonusNumberException(bonusNumber);
        }
    }

}
