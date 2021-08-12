package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoResults implements Iterable<LottoResult> {
    private List<LottoResult> results = new ArrayList<>();

    public LottoResults(List<LottoResult> results) {
        this.results = results;
    }

    public LottoResults() {}

    public void add(LottoResult lottoResult) {
        results.add(lottoResult);
    }

    @Override
    public Iterator<LottoResult> iterator() {
        return results.iterator();
    }
}
