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

    protected int matchNumberCalculate(LottoTicket lottoTicket) {
        return (int) lottoTicket.getValues().stream()
                .filter(lottoNumber -> winTicket.isInThisTicket(lottoNumber))
                .count();
    }

    protected boolean isMatchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.getValues().contains(winBonusNumber);
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int matchNumber = matchNumberCalculate(lottoTicket);
        boolean isMatchBonusNumber = isMatchBonusNumber(lottoTicket);
        return Rank.create(matchNumber, isMatchBonusNumber);
    }
}
