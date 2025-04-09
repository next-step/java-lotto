package lotto.domain;

import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> result;

    public LottoResult(Map<LottoRank, Integer> result) {
        this.result = result;
    }

    public int lottoResult(LottoRank rank) {
        return result.getOrDefault(rank, 0);
    }

    public long totalWinnings() {
        return result.entrySet().stream()
                .mapToLong(entry -> (long)entry.getKey().getMoney() * entry.getValue())
                .sum();
    }

    public double rateOfReturn() {
        return (double) totalWinnings() / (totalCount() * LottoPrice.LOTTO_PRICE);
    }

    private int totalCount() {
        return result.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
}
