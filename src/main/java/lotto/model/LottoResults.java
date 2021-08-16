package lotto.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LottoResults implements Iterable<LottoPlace> {
    private List<LottoPlace> results = new ArrayList<>();

    public LottoResults(List<LottoPlace> results) {
        this.results = results;
    }

    public LottoResults() {}

    public void add(LottoPlace lottoPlace) {
        results.add(lottoPlace);
    }

    @Override
    public Iterator<LottoPlace> iterator() {
        return results.iterator();
    }
}
