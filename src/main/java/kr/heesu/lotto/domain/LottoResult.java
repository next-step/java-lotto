package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.LottoPolicy;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Long, Long> matches;
    private final Long totalWinningPrice;
    private final PurchaseAmount amount;

    private LottoResult(Map<Long, Long> matches, Long totalWinningPrice, PurchaseAmount amount) {
        this.matches = matches;
        this.totalWinningPrice = totalWinningPrice;
        this.amount = amount;
    }

    public Map<Long, Long> getMatches() {
        return this.matches;
    }

    public Double getProfitRate() {
        return this.totalWinningPrice / amount.getAmount() * 1.0;
    }

    @Override
    public String toString() {
        return String.valueOf(matches);
    }

    public static LottoResult of(Map<Long, Long> matches, PurchaseAmount amount) {
        Map<Long, Long> matchResult = makeMatchResult(matches);
        Long totalWinningPrice = calculateTotalWinningPrice(matchResult);

        return new LottoResult(matchResult, totalWinningPrice, amount);
    }

    private static Map<Long, Long> makeMatchResult(Map<Long, Long> matches) {
        Map<Long, Long> result = new HashMap<>();

        for (LottoPolicy policy : LottoPolicy.values()) {
            result.put(policy.getCount(), 0L);
        }

        for (Map.Entry<Long, Long> entry : matches.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    private static Long calculateTotalWinningPrice(Map<Long, Long> matches) {
        Long total = 0L;

        for (LottoPolicy policy : LottoPolicy.values()) {
            total += (policy.getPrice() * matches.get(policy.getCount()));
        }

        return total;
    }

}
