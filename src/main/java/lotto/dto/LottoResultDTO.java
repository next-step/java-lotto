package lotto.dto;

import lotto.lotto.LottoMarginCalculator;

import java.util.Map;

public class LottoResultDTO {
    private Map<LottoMarginCalculator, Integer> resultMap;
    private double marginRate;

    public LottoResultDTO(Map<LottoMarginCalculator, Integer> resultMap, double marginRate) {
        this.resultMap = resultMap;
        this.marginRate = marginRate;
    }

    public Map<LottoMarginCalculator, Integer> getResultMap() {
        return resultMap;
    }

    public double getMarginRate() {
        return marginRate;
    }
}
