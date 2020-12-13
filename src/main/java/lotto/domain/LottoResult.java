package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public class LottoResult {
    private final Map<MatchPrize, Integer> result;

    public LottoResult(final Map<MatchPrize, Integer> result) {
        this.result = result;
    }

    public int findByKey(final MatchPrize matchPrize) {
        return result.get(matchPrize);
    }

    public long addTotalMoney() {
        return Arrays.stream(MatchPrize.values())
                .mapToLong(matchPrize -> matchPrize.multiplyMoney(result.get(matchPrize)))
                .sum();
    }
}
