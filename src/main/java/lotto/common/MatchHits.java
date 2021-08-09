package lotto.common;

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

}
