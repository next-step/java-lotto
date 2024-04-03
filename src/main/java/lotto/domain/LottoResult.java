package lotto.domain;

import java.util.Map;

public class LottoResult {
    private Map<WinningType, Long> map;

    public LottoResult(Map<WinningType, Long> map) {
        this.map = map;
    }

    public Long countWinnersByWinningType(WinningType type) {
        return map.getOrDefault(type, 0L);
    }

    public double returnRate(int amount) {
        Long revenue = this.map.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().getRevenue() * entry.getValue())
                .reduce(0, Long::sum);
        return Double.valueOf(revenue) / amount;
    }
}
