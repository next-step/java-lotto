package lotto.domain.rank;

import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoTicket;

public class RankCalculator {
    private LottoTicket winTicket;
    private LottoNumber winBonusNumber;

    public RankCalculator(LottoTicket lottoTicket, LottoNumber winBonusNumber) {
        this.winTicket = lottoTicket;
        this.winBonusNumber = winBonusNumber;
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
