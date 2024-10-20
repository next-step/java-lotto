package lotto.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoMargin {

    private static Map<Integer, Integer> MARGIN_MAP = new HashMap<>();
    private static int RANK_ONE = 6;
    private static int RANK_TWO = 5;
    private static int RANK_THREE = 4;
    private static int RANK_FOUR = 3;

    static {
        MARGIN_MAP.put(RANK_FOUR, 5000);
        MARGIN_MAP.put(RANK_THREE, 50000);
        MARGIN_MAP.put(RANK_TWO, 1500000);
        MARGIN_MAP.put(RANK_ONE, 2000000000);
    }

    private final double marginRate;

    public LottoMargin(int price, Map<Integer, Integer> map) {
        marginRate = calculateMarginRate(price, map);
    }

    public double calculateMarginRate(int price, Map<Integer, Integer> map) {
        return (map.get(RANK_FOUR) * MARGIN_MAP.get(RANK_FOUR)
                + map.get(RANK_THREE) * MARGIN_MAP.get(RANK_THREE)
                + map.get(RANK_TWO) * MARGIN_MAP.get(RANK_TWO)
                + map.get(RANK_ONE) * MARGIN_MAP.get(RANK_ONE)) / (double) price;
    }

    public double getMarginRate() {
        return marginRate;
    }

}
