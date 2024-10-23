package lotto.lotto;

import java.util.Map;

public class LottoMargin {

    private final double marginRate;
    private final  Map<LottoMarginCalculator, Integer> resultMap;

    public LottoMargin(int price, Map<LottoMarginCalculator, Integer> resultMap) {
        this.marginRate = LottoMarginCalculator.calculateMarginRate(price, resultMap);
        this.resultMap = resultMap;
    }

    public double getMarginRate() {
        return marginRate;
    }


}
