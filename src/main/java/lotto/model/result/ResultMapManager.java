package lotto.model.result;

import lotto.model.domain.Rank;

import java.util.LinkedHashMap;
import java.util.Map;

public class ResultMapManager {

    private ResultMapManager() {}

    public static Map<Rank, Integer> init() {
        Map<Rank, Integer> map = new LinkedHashMap<Rank, Integer>();
        map.put(Rank.FIFTH, 0);
        map.put(Rank.FOURTH, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.FIRST, 0);
        return map;
    }
}
