package lotto.domain.result;

import lotto.domain.ticket.WinningLotto;
import lotto.domain.ticket.LottoTickets;

import java.util.Map;

public class LottoStatistics {

    private final Map<Rank, Integer> results;
    private final double profitRatio;

    private LottoStatistics(LottoTickets lottoTickets, WinningLotto winningLotto, int lottoTicketPrice) {
        results = getLottoStatistics(lottoTickets, winningLotto);
        profitRatio = calculateProfitRatio(lottoTickets.size(), lottoTicketPrice);
    }

    public static LottoStatistics of(LottoTickets lottoTickets, WinningLotto winningLotto, int lottoTicketPrice) {
        return new LottoStatistics(lottoTickets, winningLotto, lottoTicketPrice);
    }

    private double calculateProfitRatio(long numberOfTickets, int lottoTicketPrice) {
        return (double) sumAllPrize() / (numberOfTickets * lottoTicketPrice);
    }

    private long sumAllPrize() {
        long sumOfPrizes = 0;
        for (Rank rank : results.keySet()) {
            sumOfPrizes += rank.getPrize() * results.get(rank);
        }
        return sumOfPrizes;
    }

    public static Map<Rank, Integer> getLottoStatistics(LottoTickets lottoTickets, WinningLotto winningLotto) {
        return lottoTickets.countRanks(winningLotto);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
