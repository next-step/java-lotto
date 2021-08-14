package lotto.domain;

import java.util.Objects;

public class LottoResult {

    private final Ranking ranking;
    private final int hits;
    public LottoResult(Ranking ranking, int hits) {
        this.ranking = ranking;
        this.hits = hits;
    }

    public boolean rankingEquals(Ranking ranking) {
        return this.ranking == ranking;
    }

    public int getHits(){
        return hits;
    }

    public int calculateCompensation(){
        return ranking.getCompensation() * hits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoResult that = (LottoResult) o;
        return hits == that.hits && ranking == that.ranking;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ranking, hits);
    }
}
