package lotto.domain;

import java.util.Map;

public class WinningReport {
    private final Map<Award, Integer> resultMap;
    private final double rateOfReturn;

    public WinningReport(Map<Award, Integer> resultMap, double rateOfReturn) {
        this.resultMap = resultMap;
        this.rateOfReturn = rateOfReturn;
    }

    public Map<Award, Integer> awardResult() {
        return resultMap;
    }

    public double rateOfReturn() {
        return rateOfReturn;
    }

}
