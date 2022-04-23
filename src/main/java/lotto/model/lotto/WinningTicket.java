package lotto.model.lotto;

import lotto.exception.InvalidBonusNumberException;
import lotto.model.rank.Rank;

public class WinningTicket {

    private static final int POTENTIAL_SECOND_NUMBER = 4;

    private final LottoTicket lottoTicket;

    private final LottoNumber bonusNumber;

    public WinningTicket(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        validateBonusNumber(lottoTicket, bonusNumber);
        this.lottoTicket = lottoTicket;
        this.bonusNumber = bonusNumber;
    }

    public Rank drawLotto(LottoTicket lottoTicket) {
        int count = this.lottoTicket.countMatches(lottoTicket);
        boolean matchBonus = lottoTicket.includeBonusNumber(bonusNumber);
        count += addCountIfSecondPotential(count, matchBonus);
        return Rank.valueOf(count, matchBonus);
    }

    private int addCountIfSecondPotential(int count, boolean matchBonus) {
        return isPotentialSecond(count, matchBonus) ? 1 : 0;
    }

    private boolean isPotentialSecond(int count, boolean matchBonus) {
        return count == POTENTIAL_SECOND_NUMBER && matchBonus;
    }

    private void validateBonusNumber(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if(lottoTicket.includeBonusNumber(bonusNumber)) {
            throw new InvalidBonusNumberException(bonusNumber);
        }
    }

}
