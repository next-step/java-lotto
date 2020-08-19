package cc.oakk.lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class LottoResults {
    private final Map<Rank, List<LottoResult>> rankMap;

    public LottoResults(List<LottoResult> lottoResultList) {
        this.rankMap = new HashMap<>();
        throwIfNull(lottoResultList).forEach(this::put);
    }

    private void put(LottoResult lottoResult) {
        get(throwIfNull(lottoResult).getRank()).add(lottoResult);
    }

    private List<LottoResult> get(Rank rank) {
        if (rankMap.containsKey(throwIfNull(rank))) {
            return rankMap.get(rank);
        }

        List<LottoResult> results = new ArrayList<>();
        rankMap.put(rank, results);
        return results;
    }

    public int getRankCount(Rank rank) {
        return get(throwIfNull(rank)).size();
    }
}
