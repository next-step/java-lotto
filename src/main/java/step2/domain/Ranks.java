package step2.domain;

import step2.serivce.LottoService;

import java.util.HashMap;
import java.util.Map;

public class Ranks {
    public static final int WINNING_COUNT = 1;
    public static final int BONUS_RANK_INDEX = 2;
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

    public void countWinning(int matchCount) {
        ranks.put(matchCount, ranks.getOrDefault(matchCount, 0) + WINNING_COUNT);
    }

    public void countBouns(LottoTicket lottoTicket, int matchCount, Bonus bonus) {
        if (matchCount == BONUS_MATCH_START_COUNT) {
            compareBonus(lottoTicket, bonus);
        }
    }

    private void compareBonus(LottoTicket lottoTicket, Bonus bonus) {
        if (bonus.matchBonusNumber(lottoTicket)) {
            ranks.put(BONUS_RANK_INDEX, ranks.getOrDefault(BONUS_RANK_INDEX, 0) + WINNING_COUNT);
        }
    }

    public int getOrDefault(int hit, int defaultNum) {
        return ranks.getOrDefault(hit, defaultNum);
    }
}
