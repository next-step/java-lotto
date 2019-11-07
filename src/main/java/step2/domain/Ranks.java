package step2.domain;

import step2.serivce.LottoService;

import java.util.HashMap;
import java.util.Map;

public class Ranks {
    public static final int WINNING_COUNT = 1;
    public static final int BONUS_RANK_INDEX = 7;
    public static final int BONUS_MATCH_START_COUNT = 5;

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

    public void countWinning(LottoTicket lottoTicket, int matchCount, Bonus bonus) {
        if (isMatchBouns(lottoTicket, matchCount, bonus)) {
            ranks.put(BONUS_RANK_INDEX, ranks.getOrDefault(BONUS_RANK_INDEX, 0) + WINNING_COUNT);
            return;
        }

        ranks.put(matchCount, ranks.getOrDefault(matchCount, 0) + WINNING_COUNT);
    }

    public boolean isMatchBouns(LottoTicket lottoTicket, int matchCount, Bonus bonus) {
        return matchCount == BONUS_MATCH_START_COUNT && bonus.matchBonusNumber(lottoTicket);
    }

    public int getOrDefault(int hit, int defaultNum) {
        return ranks.getOrDefault(hit, defaultNum);
    }
}
