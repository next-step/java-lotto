package lotto.common;

import java.util.Objects;

public class LottoResult {
    private final int expect;
    private final int hits;

    public LottoResult(int expect, int hits) {
        this.expect = expect;
        this.hits = hits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult lottoResult = (LottoResult) o;
        return expect == lottoResult.expect && hits == lottoResult.hits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(expect, hits);
    }
}
