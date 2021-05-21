package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class WinnerStatistics {

    private static final int LOTTO_TICKET_PRICE = 1000;
    private Map<LottoRank, Long> lotteryResult;

    private WinnerStatistics(Map<LottoRank, Long> lotteryResult) {
        this.lotteryResult = lotteryResult;
    }

    public static WinnerStatistics create(Map<LottoRank, Long> lotteryResult) {
        return new WinnerStatistics(lotteryResult);
    }

    public Map<LottoRank, Long> lotteryResult() {
        return Collections.unmodifiableMap(lotteryResult);
    }


    public String incomeRate() {
        long totalTickets = totalTicketCount();
        long totalRewards = totalReward();

        double incomeRate = totalRewards / (totalTickets * LOTTO_TICKET_PRICE);

        return String.format("%.2f", incomeRate);
    }

    private long totalTicketCount() {
        Set<LottoRank> lottoRanks = lotteryResult.keySet();

        return lottoRanks.stream()
                .mapToLong(lottoRank -> lotteryResult.get(lottoRank))
                .sum();
    }

    private long totalReward() {
        Set<LottoRank> lottoRanks = lotteryResult.keySet();

        return lottoRanks.stream()
                .mapToLong(lottoRank -> (lottoRank.reward() * lotteryResult.get(lottoRank)))
                .sum();
    }
}
