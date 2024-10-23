package lotto.dto;

import lotto.lotto.LottoRank;

import java.util.Map;

public class LottoResultDTO {
    private Map<LottoRank, Integer> resultMap;
    private double marginRate;

    public LottoResultDTO(Map<LottoRank, Integer> resultMap, double marginRate) {
        this.resultMap = resultMap;
        this.marginRate = marginRate;
    }

    public Map<LottoRank, Integer> getResultMap() {
        return resultMap;
    }

    public double getMarginRate() {
        return marginRate;
    }
}
