package lotto.domain.rank;

import lotto.domain.lotto.LottoTicket;

public class RankCalculator {
    private LottoTicket winTicket;

    public RankCalculator(LottoTicket lottoTicket) {
        this.winTicket = lottoTicket;
    }

    protected int matchNumberCalculate(LottoTicket lottoTicket) {
        return (int) lottoTicket.getValues().stream()
                .filter(lottoNumber -> winTicket.isInThisTicket(lottoNumber))
                .count();
    }

    public Rank getRank(LottoTicket lottoTicket) {
        int matchNumber = matchNumberCalculate(lottoTicket);
        return Rank.create(matchNumber);
    }
}
