package lotto.lotto;

import java.util.Map;

public class LottoMargin {

    private final double marginRate;
    private final  Map<LottoRank, Integer> resultMap;

    public LottoMargin(int price, Map<LottoRank, Integer> resultMap) {
        this.marginRate = LottoRank.calculateMarginRate(price, resultMap);
        this.resultMap = resultMap;
    }

    public double getMarginRate() {
        return marginRate;
    }


}
