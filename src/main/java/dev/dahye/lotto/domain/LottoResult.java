package dev.dahye.lotto.domain;

import java.util.List;

public class LottoResult {
    private final LottoTickets lottoTickets;
    private final LottoTicket winningTicket;
    private final BonusBall bonusNumber;

    public LottoResult(LottoTickets lottoTickets, LottoTicket winningTicket, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
        this.bonusNumber = BonusBall.of(bonusNumber, this.winningTicket);
    }

    public List<Rank> getMyRanks() {
        return this.lottoTickets.calculateWinningRate(winningTicket, bonusNumber);
    }

    public int getTotalCountOf(Rank target) {
        return (int) this.getMyRanks().stream()
                .filter(rank -> rank == target)
                .count();
    }

    public double getMyWinningRate(LottoMoney lottoMoney) {
        int totalPrize = calculateTotalPrize();

        return lottoMoney.divideTotalPrizeByMoney(totalPrize);
    }

    public int calculateTotalPrize() {
        int totalPrize = 0;

        for (Rank rank : this.getMyRanks()) {
            totalPrize += rank.getPrize();
        }

        return totalPrize;
    }
}
