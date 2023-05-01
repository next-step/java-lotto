package step2.domain;

import java.util.HashMap;
import java.util.Map;

public enum LottoResult {
    MATCHED_3(3, 5000),
    MATCHED_4(4, 50000),
    MATCHED_5(5, 1500000),
    MATCHED_6(6, 2000000000),
    ;

    private final int numberOfMatched;
    private final int winningPrice;

    LottoResult(int numberOfMatched, int winningPrice) {
        this.numberOfMatched = numberOfMatched;
        this.winningPrice = winningPrice;
    }

    public static Map<Integer, Integer> winningPriceMap() {
        Map<Integer, Integer> map = new HashMap<>();
        for (LottoResult result : LottoResult.values()) {
            map.put(result.numberOfMatched, result.winningPrice);
        }
        return map;
    }
}
