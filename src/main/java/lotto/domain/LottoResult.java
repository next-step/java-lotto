package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> value;

    public LottoResult(Map<LottoRank, Integer> lottoResult) {
        this.value = lottoResult;
    }

    public int getCount(LottoRank rank) {
        return value.getOrDefault(rank, 0);
    }

}
