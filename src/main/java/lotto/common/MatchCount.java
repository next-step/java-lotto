package lotto.common;

public class MatchCount {
    private int threeMatches;

    private int FourMatches;
    private int FiveMatches;
    private int SixMatches;
    private MatchCount() {
    }

    private MatchCount(int threeMatches, int fourMatches, int fiveMatches, int sixMatches) {
        this.threeMatches = threeMatches;
        FourMatches = fourMatches;
        FiveMatches = fiveMatches;
        SixMatches = sixMatches;
    }

    public static MatchCount create(int threeMatches, int fourMatches, int fiveMatches, int sixMatches){
        return new MatchCount(threeMatches, fourMatches, fiveMatches, sixMatches);
    }

    public int getThreeMatches() {
        return threeMatches;
    }

    public int getFourMatches() {
        return FourMatches;
    }

    public int getFiveMatches() {
        return FiveMatches;
    }

    public int getSixMatches() {
        return SixMatches;
    }

}
