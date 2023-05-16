package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> lottoResult = Rank.initLottoResult();

    public LottoResult(List<Rank> rank) {
        rank.forEach(this::deriveResult);
    }

    private void deriveResult(Rank rank) {
        int countPerRank = lottoResult.get(rank);
        lottoResult.put(rank, ++countPerRank);
    }

    public double getRateResult(int ticketCount) {
        int totalReward = getTotalReward();
        Money totalMoney = new Money(totalReward);
        return totalMoney.divide(new Money(ticketCount * Cost.ONE_LOTTO_TICKET_PRICE));
    }

    public int getTotalReward() {
        return lottoResult.entrySet()
                .stream()
                .filter(o -> o.getValue() > 0)
                .mapToInt(o -> o.getKey().prize() * o.getValue())
                .sum();
    }

    public Map<Rank, Integer> getRankResult() {
        return new LinkedHashMap<>(lottoResult);
    }

}
