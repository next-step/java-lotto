package dev.dahye.lotto.domain;

import java.util.List;

public class LottoResult {
    private final LottoTickets lottoTickets;
    private final Winning winning;

    public LottoResult(LottoTickets lottoTickets, Winning winning) {
        this.lottoTickets = lottoTickets;
        this.winning = winning;
    }

    public List<Rank> getMyRanks() {
        return this.lottoTickets.rankings(winning);
    }

    public int getTotalCountOf(Rank target) {
        return (int) this.getMyRanks().stream()
                .filter(rank -> rank == target)
                .count();
    }

    public double getMyWinningRate(LottoMoney lottoMoney) {
        LottoMoney totalPrize = calculateTotalPrize();

        return lottoMoney.divideBy(totalPrize);
    }

    public LottoMoney calculateTotalPrize() {
        int totalPrize = 0;

        for (Rank rank : this.getMyRanks()) {
            totalPrize += rank.getPrize();
        }

        return new LottoMoney(totalPrize);
    }
}
