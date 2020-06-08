package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.DoubleUtils;

import java.util.List;

public class LottoResult {
    private final LottoTickets lottoTickets;
    private final LottoTicket winningTicket;
    private final BonusBall bonusNumber;

    public LottoResult(LottoTickets lottoTickets, List<Integer> winningNumbers, int bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningTicket = LottoTicket.manualIssued(winningNumbers);
        this.bonusNumber = BonusBall.createBy(bonusNumber, this.winningTicket);
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
