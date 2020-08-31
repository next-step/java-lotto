package cc.oakk.lotto.model;

import cc.oakk.lotto.model.prizeprovider.LottoPrizeProvider;
import cc.oakk.lotto.view.printer.Printable;
import cc.oakk.lotto.view.printer.Printer;

import java.util.*;

import static cc.oakk.lotto.util.ValidationAdapters.throwIfNull;

public class LottoResults implements Printable<LottoResults> {
    private final Map<Rank, List<LottoResult>> lottoResults;

    public LottoResults(List<LottoResult> lottoResultList) {
        this.lottoResults = new HashMap<>();
        throwIfNull(lottoResultList).forEach(this::put);
    }

    private void put(LottoResult lottoResult) {
        get(throwIfNull(lottoResult).getRank()).add(lottoResult);
    }

    private List<LottoResult> get(Rank rank) {
        if (lottoResults.containsKey(throwIfNull(rank))) {
            return lottoResults.get(rank);
        }

        List<LottoResult> results = new ArrayList<>();
        lottoResults.put(rank, results);
        return results;
    }

    public int size() {
        return lottoResults.size();
    }

    public long calculateRevenue(LottoPrizeProvider<?> provider) {
        throwIfNull(provider);
        return lottoResults.values().stream()
                .flatMap(Collection::stream)
                .map(r -> provider.getPrizeByRank(r.getRank()).getValue())
                .reduce(0L, (acc, cur) -> acc += cur);
    }

    public int getRankCount(Rank rank) {
        return get(throwIfNull(rank)).size();
    }

    @Override
    public void print(Printer<LottoResults> printer) {
        printer.print(this);
    }
}
