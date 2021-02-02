package lotto.domain;

import java.util.EnumMap;

public class WinnerStatistics {
    private final EnumMap<Rank, Integer> results = new EnumMap<>(Rank.class);
    private final int purchaseAmount;
    private long winningAmount = 0L;

    /**
     * @param goldenTicket 당첨 번호 (보너스 볼 포함)
     * @param lottoTickets 구입한 로또들
     */
    public WinnerStatistics(final GoldenTicket goldenTicket, final Tickets lottoTickets) {
        analyze(goldenTicket, lottoTickets);  // 당첨 통계 분석
        this.purchaseAmount = lottoTickets.getPurchaseAmount();
    }

    private void analyze(final GoldenTicket goldenTicket, final Tickets lottoTickets) {
        for (final LottoTicket lottoTicket : lottoTickets.getLottoTickets()) {
            final LottoResult result = new LottoResult(goldenTicket, lottoTicket);
            final Rank rank = result.getRank();
            results.put(rank, results.getOrDefault(rank, 0) + 1);
            winningAmount += rank.getAmount();
        }
    }

    public EnumMap<Rank, Integer> getResults() {
        return results;
    }

    public double getEarningRate() {
        final double origin = winningAmount / (double) purchaseAmount;
        return Math.floor(origin * 100) / 100;
    }
}