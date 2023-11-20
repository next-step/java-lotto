package lotto;

import java.util.Iterator;
import java.util.List;

public class LottoMatchResult implements Iterable<LottoMatch> {
    private final List<LottoMatch> lottoMatches;

    public LottoMatchResult(List<LottoMatch> lottoMatches) {
        this.lottoMatches = lottoMatches;
    }

    public List<LottoMatch> lottoMatches() {
        return this.lottoMatches;
    }

    @Override
    public Iterator<LottoMatch> iterator() {
        return this.lottoMatches.iterator();
    }
}
