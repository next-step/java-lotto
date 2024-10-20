package lotto.dto;

import java.util.Map;

public class LottoResultDTO {
    private Map<Integer, Integer> resultMap;
    private double marginRate;

    public LottoResultDTO(Map<Integer, Integer> resultMap, double marginRate) {
        this.resultMap = resultMap;
        this.marginRate = marginRate;
    }

    public Map<Integer, Integer> getResultMap() {
        return resultMap;
    }

    public double getMarginRate() {
        return marginRate;
    }
}
