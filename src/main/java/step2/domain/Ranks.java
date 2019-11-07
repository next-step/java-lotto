package step2.domain;

import step2.serivce.LottoService;

import java.util.HashMap;
import java.util.Map;

public class Ranks {
    private Map<Integer, Integer> ranks = new HashMap<>();

    public Double calculateProfit(int lottoTicketsSize) {
        int sum = 0;

        for (int matchCount : ranks.keySet()) {
            int countOfMatchTicket = ranks.get(matchCount);

            sum += RankEnum.getReward(matchCount) * countOfMatchTicket;
        }

        int purchaseAmount = lottoTicketsSize * LottoService.LOTTO_PRICE;
        return Double.parseDouble(String.format("%.2f", sum / (double) purchaseAmount));
    }

    public void countWinning(int matchCount) {
        ranks.put(matchCount, ranks.getOrDefault(matchCount, 0) + 1);
    }

    public int getOrDefault(int hit, int defaultNum) {
        return ranks.getOrDefault(hit, defaultNum);
    }
}
