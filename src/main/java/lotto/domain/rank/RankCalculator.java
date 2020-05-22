package lotto.domain.rank;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.rank.exceptions.BonusNumberDuplicatedWithLottoTicket;

public class RankCalculator {
    private LottoTicket winTicket;
    private LottoNumber winBonusNumber;

    public RankCalculator(LottoTicket lottoTicket, LottoNumber winBonusNumber) {
        bonusNumberValidation(lottoTicket, winBonusNumber);
        this.winTicket = lottoTicket;
        this.winBonusNumber = winBonusNumber;
    }

    private void bonusNumberValidation(LottoTicket lottoTicket, LottoNumber bonusNumber) {
        if (lottoTicket.getValues().contains(bonusNumber)) {
            throw new BonusNumberDuplicatedWithLottoTicket("Bonus number cannot duplicated with win ticket numbers");
        }
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int matchNumber = winTicket.howManyMatch(lottoTicket);
        boolean isMatchBonusNumber = lottoTicket.isInThisTicket(winBonusNumber);
        return Rank.create(matchNumber, isMatchBonusNumber);
    }
}
