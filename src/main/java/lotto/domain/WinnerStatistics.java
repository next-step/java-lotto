package lotto.domain;

import java.util.Map;
import java.util.Set;

public class WinnerStatistics {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final Long TICKET_COUNT_ZERO = 0L;

    private Map<LottoRank, Long> lotteryResult;

    private WinnerStatistics(Map<LottoRank, Long> lotteryResult) {
        this.lotteryResult = lotteryResult;
    }

    public static WinnerStatistics create(Map<LottoRank, Long> lotteryResult) {
        return new WinnerStatistics(lotteryResult);
    }

    public String getIncomeRate() {
        double incomeRate = calculateRate();

        return String.format("%.2f", incomeRate);
    }

    private long calculateRate() {
        long totalTickets = getCountOfTickets();
        long totalRewards = getTotalReward();

        return totalRewards / (totalTickets * LOTTO_TICKET_PRICE);
    }

    public long getNumberOfWinners(LottoRank lottoRank) {
        return lotteryResult.getOrDefault(lottoRank, TICKET_COUNT_ZERO);
    }

    private long getCountOfTickets() {
        Set<LottoRank> lottoRanks = lotteryResult.keySet();

        return lottoRanks.stream()
                .mapToLong(lottoRank -> lotteryResult.get(lottoRank))
                .sum();
    }

    private long getTotalReward() {
        Set<LottoRank> lottoRanks = lotteryResult.keySet();

        return lottoRanks.stream()
                .mapToLong(lottoRank -> (lottoRank.reward() * lotteryResult.get(lottoRank)))
                .sum();
    }

    public boolean isLoss() {
        if (calculateRate() < 1) {
            return true;
        }
        return false;
    }
}
