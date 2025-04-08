package domain.Lotto;

import java.util.Map;

public class LottoResult {
    public static final Map<Integer, Integer> PRIZE_MONEY = Map.of(
            3, 5000,
            4, 50000,
            5, 1500000,
            6, 2000000000
    );

    private final Map<Rank, Integer> matchCounts;

    public LottoResult(Map<Rank, Integer> rankCounts) {
        this.matchCounts = rankCounts;
    }

    public double calculateProfitRate(int totalSpent) {
        int totalPrize = matchCounts.entrySet().stream()
                .mapToInt(entry -> PRIZE_MONEY.getOrDefault(entry.getKey(), 0) * entry.getValue())
                .sum();
        return (double) totalPrize / totalSpent;
    }
    /**
     * 당첨 개수별 로또 개수를 반환합니다.
     *
     * @return Map<Integer, Integer> 형식의 값으로,
     *         - key: 당첨 번호 개수 (예: 3, 4, 5, 6)
     *         - value: 해당 개수만큼 맞춘 로또 티켓의 수
     */
    public Map<Rank, Integer> getMatchCounts() {
        return matchCounts;
    }
}
