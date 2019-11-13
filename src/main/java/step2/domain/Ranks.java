package step2.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static step2.domain.LottoTicket.LOTTO_PRICE;

public class Ranks {
    public static final int WINNING_COUNT = 1;
    public static final int DEFAULT_VALUE = 0;

    private Map<RankEnum, Integer> ranks = new HashMap<>();

    public Ranks(LottoTickets lottoTickets, List<Integer> winnerNums, LottoNum bonus) {
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();

        for (LottoTicket lottoTicket : tickets) {
            int matchCount = lottoTicket.countMatchNumber(winnerNums);
            boolean isBonusMatch = bonus.matchNumber(lottoTicket);

            RankEnum rank = RankEnum.valueOf(matchCount, isBonusMatch);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + WINNING_COUNT);
        }
    }

    public int sumReward() {
        int sum = 0;

        for (RankEnum rank : ranks.keySet()) {
            sum += rank.getReward() * ranks.get(rank);
        }

        return sum;
    }

    public Double calculateProfit(int lottoTicketsSize) {
        int purchaseAmount = lottoTicketsSize * LOTTO_PRICE;
        return Double.parseDouble(String.format("%.2f", sumReward() / (double) purchaseAmount));
    }

    public int getOrDefault(RankEnum hit) {
        return ranks.getOrDefault(hit, DEFAULT_VALUE);
    }
}
