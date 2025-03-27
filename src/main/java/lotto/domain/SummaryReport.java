package lotto.domain;

import java.util.Map;

public class SummaryReport {
    private final Map<PrizeRank, Integer> summary;

    public SummaryReport(Map<PrizeRank, Integer> summary) {
        this.summary = summary;
    }

    public float getProfit() {
        int count = 0;
        int sum = 0;
        for (PrizeRank prize : summary.keySet()) {
            count += summary.get(prize);
            sum += prize.getPrize() * summary.get(prize);
        }
        return (float) sum / (count * LottoTicket.PRICE);
    }

    public int getTicketCount(PrizeRank prize) {
        return summary.getOrDefault(prize, 0);
    }
}
