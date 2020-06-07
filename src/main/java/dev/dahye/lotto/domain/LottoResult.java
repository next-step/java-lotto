package dev.dahye.lotto.domain;

import dev.dahye.lotto.util.DoubleUtils;

import java.util.ArrayList;
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

    public double getMyWinningRate(int money) {
        int totalPrize = 0;

        for (Rank rank : this.getMyRanks()) {
            totalPrize += rank.getPrize();
        }

        return divideTotalPrizeByMoney(totalPrize, money);
    }

    public static double divideTotalPrizeByMoney(int totalPrize, int money) {
        return DoubleUtils.parseDoubleSecondDigit((double) totalPrize / money);
    }
}
