package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.Map;

public class LottoResult {

    private final Map<LottoRank, Integer> value;

    public LottoResult(Map<LottoRank, Integer> lottoResult) {
        this.value = lottoResult;
    }

    public int getFirstCount() {
        return value.getOrDefault(LottoRank.FIRST, 0);
    }

    public int getSecondCount() {

        return value.getOrDefault(LottoRank.SECOND, 0);
    }

    public int getThirdCount() {
        return value.getOrDefault(LottoRank.THIRD, 0);
    }

    public int getFourthCount() {
        return value.getOrDefault(LottoRank.FOURTH, 0);
    }

}
