package lotto.domain;

import java.util.EnumMap;
import java.util.List;

public class WinnerStatistics {
    private final GoldenTicket goldenTicket;
    private final List<LottoTicket> pickedLottoTickets;
    private final EnumMap<Rank, Integer> results = new EnumMap<>(Rank.class);

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

    public int getRankCount(final Rank rank) {
        return results.getOrDefault(rank, 0);
    }

    public double calculateEarningRate() {
        PurchaseAmount purchaseAmount = new PurchaseAmount(pickedLottoTickets);
        long totalPrize = calculateTotalPrize();
        double earningsRate = purchaseAmount.calculateEarningsRateByTotalPrize(totalPrize);
        return Math.floor(earningsRate * 100) / 100;
    }

    private long calculateTotalPrize() {
        long totalPrize = 0L;
        for (final Rank rank : results.keySet()) {
            totalPrize += results.get(rank);
        }
        return totalPrize;
    }
}
