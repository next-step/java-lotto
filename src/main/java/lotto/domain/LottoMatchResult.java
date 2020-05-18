package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private final Map<LottoMatch, Integer>  lottoMatchCountMap;

    public LottoMatchResult() {
        lottoMatchCountMap = new HashMap<>();
    }

    void increment(LottoMatch lottoMatch){
        lottoMatchCountMap.put(lottoMatch, lottoMatchCountMap.getOrDefault(lottoMatch, 0) +1);
    }

    public int get(LottoMatch lottoMatch) {
        return lottoMatchCountMap.getOrDefault(lottoMatch, 0);
    }

}
