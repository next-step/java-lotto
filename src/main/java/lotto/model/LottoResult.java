package lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class LottoResult {

    private Map<LottoLevels, Integer> map;

    public LottoResult() {
        map = new EnumMap<>(LottoLevels.class);
    }

    public void put(int matchingCount) {
        LottoLevels match = LottoLevels.match(matchingCount);
        Integer count = map.getOrDefault(match, 0);
        map.put(match, ++count);
    }

    public int get(LottoLevels level) {
        return map.getOrDefault(level, 0);
    }

    public double getRateOfReturn() {
        return getTotalReturnMoney() / getBoughtLottoCount();
    }

    private int getTotalReturnMoney() {
        return 0;
    }

    private int getBoughtLottoCount() {
        return 0;
    }
}
