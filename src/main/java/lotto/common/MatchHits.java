package lotto.common;

import java.util.Objects;

public class MatchHits {
    private int threeMatchHits;

    private int fourMatchHits;
    private int fiveMatchHits;
    private int sixMatchHits;

    private MatchHits() {
    }

    private MatchHits(int threeMatchHits, int fourMatchHits, int fiveMatchHits, int sixMatchHits) {
        this.threeMatchHits = threeMatchHits;
        this.fourMatchHits = fourMatchHits;
        this.fiveMatchHits = fiveMatchHits;
        this.sixMatchHits = sixMatchHits;
    }

    public static MatchHits create(int threeMatches, int fourMatches, int fiveMatches, int sixMatches){
        return new MatchHits(threeMatches, fourMatches, fiveMatches, sixMatches);
    }

    public int getThreeMatchHits() {
        return threeMatchHits;
    }

    public int getFourMatchHits() {
        return fourMatchHits;
    }

    public int getFiveMatchHits() {
        return fiveMatchHits;
    }

    public int getSixMatchHits() {
        return sixMatchHits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchHits matchHits = (MatchHits) o;
        return threeMatchHits == matchHits.threeMatchHits && fourMatchHits == matchHits.fourMatchHits && fiveMatchHits == matchHits.fiveMatchHits && sixMatchHits == matchHits.sixMatchHits;
    }

    @Override
    public int hashCode() {
        return Objects.hash(threeMatchHits, fourMatchHits, fiveMatchHits, sixMatchHits);
    }
}
