package step3.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int DEFAULT_RANK_VALUE = 1;

    private Map<Integer, List<Lotto>> lottoResultMap;

    public LottoResult(Map<Integer, List<Lotto>> lottoResultMap) {
        this.lottoResultMap = lottoResultMap;
    }

    public EnumMap<Rank, Integer> winningResult() {
        EnumMap<Rank, Integer> enumMap = new EnumMap(Rank.class);

        for (Integer key : lottoResultMap.keySet()) {
            setRankEnumMap(enumMap, key);
        }
        return enumMap;
    }

    private void setRankEnumMap(EnumMap<Rank, Integer> enumMap, Integer key) {
        for (Lotto lotto : lottoResultMap.get(key)) {
            Rank rank = Rank.valueOf(key, lotto.isMatchBonus());
            enumMap.computeIfPresent(rank, (k, v)->v+DEFAULT_RANK_VALUE);
            enumMap.putIfAbsent(rank,DEFAULT_RANK_VALUE);
        }
    }

    public List<Lotto> getLottos(int key) {
        return lottoResultMap.getOrDefault(key, new ArrayList<>());
    }
}
