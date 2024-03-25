package lotto;

import java.util.List;

public class LottoResult {
    private final List<Rank> ranks;
    private final Money paidMoney;

    public LottoResult(List<Rank> ranks, Money paidMoney) {
        this.ranks = ranks;
        this.paidMoney = paidMoney;
    }

    public LottoSummary toLottoSummary() {
        return new LottoSummary(ranks, paidMoney);
    }
}
