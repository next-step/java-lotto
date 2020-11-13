package step2.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class LottoMatcher {
    private Map<LottoRank, Integer> result = new HashMap<>();

    public LottoMatcher() {
        for (LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }
    }

    public void increaseMatchLottoCount(int match) {
        result.put(getLottoRank(match), getLottoCount(getLottoRank(match)));
    }

    private LottoRank getLottoRank(int match) {
        return LottoRank.valueOf(match);
    }

    private int getLottoCount(LottoRank lottoRank) {
        return Optional.of(result.get(lottoRank) + 1).orElse(0);
    }

    public Map<LottoRank, Integer> getResult() {
        return result;
    }
}
