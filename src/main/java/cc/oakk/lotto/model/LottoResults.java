package cc.oakk.lotto.model;

import cc.oakk.lotto.view.printer.Printable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class LottoResults implements Printable<LottoResults> {
    private final Map<Rank, List<LottoResult>> rankMap;
    private final List<LottoResult> lottoResultList;

    public LottoResults(List<LottoResult> lottoResultList) {
        this.rankMap = new HashMap<>();
        this.lottoResultList = lottoResultList;
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

    public int size() {
        return lottoResultList.size();
    }

    public long calculateRevenue(LottoPrizeProvider<?> provider) {
        throwIfNull(provider);
        return lottoResultList.stream()
                .map(r -> provider.getPrizeByRank(r.getRank()).getValue())
                .reduce(0L, (acc, cur) -> acc += cur);
    }

    public int getRankCount(Rank rank) {
        return get(throwIfNull(rank)).size();
    }

    @Override
    public LottoResults print() {
        return this;
    }
}
