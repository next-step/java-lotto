package step2.domain;

import java.util.HashMap;
import java.util.Map;

import static step2.domain.LottoTicket.LOTTO_PRICE;

public class Ranks {
    public static final int WINNING_COUNT = 1;

    private Map<RankEnum, Integer> ranks = new HashMap<>();

    public int sumReward() {
        int sum = 0;

        for (RankEnum rank : ranks.keySet()) {
            sum += rank.getReward() * rank.getMatchCount();
        }

        return sum;
    }

    public Double calculateProfit(int lottoTicketsSize) {
        int purchaseAmount = lottoTicketsSize * LOTTO_PRICE;
        return Double.parseDouble(String.format("%.2f", sumReward() / (double) purchaseAmount));
    }

    public void countWinning(LottoTicket lottoTicket, int matchCount, Bonus bonus) {
        boolean isBonusMatch = bonus.matchBonusNumber(lottoTicket);
        if (isBonusMatch) {
            RankEnum rank = RankEnum.valueOf(matchCount, isBonusMatch);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + WINNING_COUNT);
            return;
        }

        RankEnum rank = RankEnum.valueOf(matchCount, isBonusMatch);
        ranks.put(rank, ranks.getOrDefault(rank, 0) + WINNING_COUNT);
    }

    public int getOrDefault(RankEnum hit, int defaultNum) {
        return ranks.getOrDefault(hit, defaultNum);
    }
}
