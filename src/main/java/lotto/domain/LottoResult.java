package lotto.domain;

import java.util.HashMap;

public class LottoResult {

    private final HashMap<Rank, Integer> resultMap;

    public LottoResult(HashMap<Rank, Integer> resultMap) {
        this.resultMap = resultMap;
    }

}
