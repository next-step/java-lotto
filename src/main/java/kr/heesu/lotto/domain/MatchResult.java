package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.LottoPolicy;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {
    private static final Long ZERO = 0L;

    private final Map<Long, Long> result;

    private MatchResult(Map<Long, Long> result) {
        this.result = result;
    }

    public static MatchResult of(Map<Long, Long> matches) {
        Map<Long, Long> result = initializeResultMap(matches);
        return new MatchResult(result);
    }

    private static Map<Long, Long> initializeResultMap(Map<Long, Long> matches) {
        Map<Long, Long> result = new HashMap<>();

        for (LottoPolicy policy : LottoPolicy.values()) {
            result.put(policy.getCount(), ZERO);
        }

        for (Map.Entry<Long, Long> entry : matches.entrySet()) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }

    public Long getTotalWinningPrice() {
        Long total = ZERO;

        for (LottoPolicy policy : LottoPolicy.values()) {
            total += (policy.getPrice() * this.result.get(policy.getCount()));
        }

        return total;
    }

    public Long getMatchFrequency(Long match) {
        return this.result.get(match);
    }
}
