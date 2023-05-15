package lotto.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    public static final int ONE_LOTTO_TICKET_PRICE = 1_000;
    private final Map<Rank, Integer> lottoResult = Rank.initLottoResult();

    public LottoResult(List<Rank> rank) {
        rank.forEach(this::deriveResult);
    }

    private void deriveResult(Rank rank) {
        int countPerRank = lottoResult.get(rank);
        lottoResult.put(rank, ++countPerRank);
    }

    public double getRateResult(int ticketCount) {
        long totalReward = getTotalReward();

        return (double) totalReward / (ticketCount * ONE_LOTTO_TICKET_PRICE);
    }

    public long getTotalReward() {
        return lottoResult.entrySet()
                .stream()
                .filter(o -> o.getValue() > 0)
                .mapToLong(o -> (long) o.getKey().prize() * o.getValue())
                .sum();
    }

    public Map<Rank, Integer> getRankResult() {
        return new LinkedHashMap<>(lottoResult);
    }

}
