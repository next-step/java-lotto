package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoDrawResponse {
    private final Map<Award, Integer> lottoResult = new HashMap<>();

    public LottoDrawResponse() {
        lottoResult.put(Award.FIRST, 0);
        lottoResult.put(Award.SECOND, 0);
        lottoResult.put(Award.THIRD, 0);
        lottoResult.put(Award.FOURTH, 0);
        lottoResult.put(Award.FIFTH, 0);
        lottoResult.put(Award.BANG, 0);
    }

    public void addOne(Award award) {
        lottoResult.computeIfPresent(award, (key, value) -> ++value);
    }

    public Map<Award, Integer> getLottoResult() {
        return Collections.unmodifiableMap(lottoResult);
    }
}
