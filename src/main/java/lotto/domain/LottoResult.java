package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<Integer, Integer> lottoResult = new HashMap<>();

    public LottoResult() {
        lottoResult.put(3, 0);
        lottoResult.put(4, 0);
        lottoResult.put(5, 0);
        lottoResult.put(6, 0);
    }

    public void addMatch(int match) {
        if (match >= 3 && match <= 6) {
            lottoResult.put(match, lottoResult.get(match) + 1);
        }
    }

    public int getCount(int match) {
        return lottoResult.getOrDefault(match, 0);
    }
}
