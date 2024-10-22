package lotto.lotto;

import java.util.Map;

public class LottoMargin {

    private final double marginRate;
    private final int price;
    private final  Map<Integer, Integer> resultMap;

    public LottoMargin(int price, Map<Integer, Integer> resultMap) {
        this.marginRate = LottoMarginCalculator.calculateMarginRate(price, resultMap);
        this.price = price;
        this.resultMap = resultMap;
    }

    public double getMarginRate() {
        return marginRate;
    }


}
