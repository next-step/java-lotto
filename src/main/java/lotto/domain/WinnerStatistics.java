package lotto.domain;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinnerStatistics {
    private final GoldenTicket goldenTicket;
    private final List<LottoTicket> pickedLottoTickets;
    private final Map<Rank, Integer> results = new EnumMap<>(Rank.class);

    /**
     * @param goldenTicket       당첨 번호 (보너스 볼 포함)
     * @param pickedLottoTickets 구입한 로또
     */
    public WinnerStatistics(final GoldenTicket goldenTicket, final List<LottoTicket> pickedLottoTickets) {
        this.goldenTicket = goldenTicket;
        this.pickedLottoTickets = pickedLottoTickets;
        analyze();
    }

    private void analyze() {
        for (LottoTicket lottoTicket : pickedLottoTickets) {
            LottoJudge judge = new LottoJudge(goldenTicket, lottoTicket);
            Rank rank = judge.determine();
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
    }

    public int getWinningCountByRank(final Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    public double calculateEarningRate() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(this.pickedLottoTickets);
        BigDecimal totalPrize = calculateTotalPrize();
        double earningsRate = purchaseAmount.calculateEarningsRateByTotalPrize(totalPrize);
        return Math.floor(earningsRate * 100) / 100;
    }

    private BigDecimal calculateTotalPrize() {
        BigDecimal totalPrize = BigDecimal.ZERO;
        for (final Map.Entry<Rank, Integer> rankEntry : results.entrySet()) {
            Rank rank = rankEntry.getKey();
            int count = results.get(rank);
            totalPrize = totalPrize.add(rank.getTotalPrizeByCount(count));
        }
        return totalPrize;
    }
}
