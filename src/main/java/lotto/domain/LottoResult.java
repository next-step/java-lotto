package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    final static int PRICE = 1000;

    private static Map<Rank, Integer> result;
    private final int payment;

    public LottoResult(int lottoTickets) {
        this.payment = lottoTickets * PRICE;
        result = new LinkedHashMap<>();
        for (Rank r : Rank.values()) {
            result.put(r, 0);
        }
    }

    public Map<Rank, Integer> getResult() {
        return result;
    }

    public double getProfitRatio() {
        return getProfit() / payment;
    }

    public static void saveLottoResult(int matchingScore, boolean matchBonus) {
        if (matchingScore > 2) {
            Rank rank = Rank.getProfitByMatchingScore(matchingScore, matchBonus);
            result.put(rank, result.get(rank) + 1);
        }
    }

    private double getProfit() {
        return result.keySet()
                .stream()
                .mapToDouble(p -> p.getProfit() * result.get(p))
                .reduce(0L, Double::sum);
    }

    public static LottoResult getLottoResult(List<LottoTicket> lottoTickets, WinningCondition winningCondition) {
        LottoResult lottoResult = new LottoResult(lottoTickets.size());
        lottoTickets.forEach(lottoTicket -> getSingleLottoResult(lottoTicket, winningCondition));
        return lottoResult;
    }

    private static void getSingleLottoResult(LottoTicket lottoTicket, WinningCondition winningCondition) {
        long matchingScore = lottoTicket.getMatchingScore(winningCondition);
        final boolean matchBonus = lottoTicket.getMatchBonus(winningCondition);

        saveLottoResult(Long.valueOf(matchingScore).intValue(), matchBonus);
    }
}
