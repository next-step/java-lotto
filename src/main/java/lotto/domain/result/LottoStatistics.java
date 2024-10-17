package lotto.domain.result;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.WinningLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {

    private final Map<Rank, Integer> results;
    private final double profitRatio;

    private LottoStatistics(List<LottoTicket> lottoTickets, WinningLotto winningLotto, int lottoTicketPrice) {
        this.results = generateRankCounts(lottoTickets, winningLotto);
        this.profitRatio = generateProfitRatio(lottoTickets.size(), lottoTicketPrice);
    }

    public static LottoStatistics of(List<LottoTicket> lottoTickets, WinningLotto winningLotto, int lottoTicketPrice) {
        return new LottoStatistics(lottoTickets, winningLotto, lottoTicketPrice);
    }

    public Map<Rank, Integer> generateRankCounts(List<LottoTicket> lottoTickets, WinningLotto winningLotto) {
        Map<Rank, Integer> rankCounts = initializeRankCounts();

        for (LottoTicket lottoTicket : lottoTickets) {
            Rank rank = lottoTicket.match(winningLotto);
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }

        return rankCounts;
    }

    private Map<Rank, Integer> initializeRankCounts() {
        Map<Rank, Integer> countRanks = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            countRanks.put(rank, 0);
        }
        return countRanks;
    }

    public double generateProfitRatio(long numberOfTickets, int lottoTicketPrice) {
        double profitRatio = calculateProfitRatio(sumAllPrize(results), numberOfTickets, lottoTicketPrice);
        return Math.floor(profitRatio * 100) / 100.0;
    }

    private long sumAllPrize(Map<Rank, Integer> results) {
        long sumOfPrizes = 0;
        for (Rank rank : results.keySet()) {
            sumOfPrizes += rank.getPrizeAmount() * results.get(rank);
        }
        return sumOfPrizes;
    }

    private double calculateProfitRatio(double sumOfPrizes, long numberOfTickets, int lottoTicketPrice) {
        return sumOfPrizes / (numberOfTickets * lottoTicketPrice);
    }

    public Map<Rank, Integer> getResults() {
        return results;
    }

    public double getProfitRatio() {
        return profitRatio;
    }

}
