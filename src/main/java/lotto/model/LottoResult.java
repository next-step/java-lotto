package lotto.model;

import java.util.*;

public class LottoResult {

    private Map<Prize, Integer> resultMap;

    private LottoResult(Map<Prize, Integer> resultMap) {
        this.resultMap = resultMap;
    }

    public static LottoResult of(List<Prize> prizes) {
        Map<Prize, Integer> prizeMap = new EnumMap(Prize.class);
        for (Prize prize : prizes) {
            int count = prizeMap.getOrDefault(prize, 0);
            prizeMap.put(prize, ++count);
        }
        return new LottoResult(prizeMap);
    }

    public int getCount(Prize prize) {
        return resultMap.get(prize);
    }
}
