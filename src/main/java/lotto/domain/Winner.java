package lotto.domain;

import java.util.List;

public class Winner {

    private Ranks ranks;
    private Double profit;

    public Winner(Ranks ranks, Double profit) {
        this.ranks = ranks;
        this.profit = profit;
    }

    public Winner(LottoTickets lottoTickets, WinningLotto winningLotto) {
        ranks = new Ranks(lottoTickets, winningLotto);
    }

    public Winner ofProfit(int lottoTicketsSize) {
        return new Winner(ranks, ranks.calculateProfit(lottoTicketsSize));
    }

    public Ranks getRanks() {
        return this.ranks;
    }

    public String toStringProfit() {
        return this.profit.toString();
    }
}
