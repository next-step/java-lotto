package lotto.model.lotto;

import lotto.exception.InvalidBonusNumberException;
import lotto.model.rank.Rank;

import java.util.Set;

public class WinningTicket {

    private final LottoTicket lottoTicket;

    private final LottoNumber bonusNumber;

    public WinningTicket(Set<LottoNumber> numbers, LottoNumber bonusNumber) {
        this(new LottoTicket(numbers), bonusNumber);
    }

    public WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        validateBonusNumber(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public Rank drawLotto(LottoTicket lottoTicket) {
        int count = this.lottoTicket.countMatches(lottoTicket);
        boolean matchBonus = lottoTicket.includeBonusNumber(bonusNumber);
        return Rank.valueOf(count, matchBonus);
    }

    private void validateBonusNumber(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if(lottoTicket.includeBonusNumber(bonusNumber)) {
            throw new InvalidBonusNumberException(bonusNumber);
        }
    }

}
