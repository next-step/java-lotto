package lotto.domain;

public class LottoResult {
    private final int threeMatches;
    private final int fourMatches;
    private final int fiveMatches;
    private final int sixMatches;
    private final double rate;

    public LottoResult(int three, int four, int five, int six, double rate) {
        this.threeMatches = three;
        this.fourMatches = four;
        this.fiveMatches = five;
        this.sixMatches = six;
        this.rate = rate;
    }

    public int getThreeMatches() {
        return threeMatches;
    }

    public int getFourMatches() {
        return fourMatches;
    }

    public int getFiveMatches() {
        return fiveMatches;
    }

    public int getSixMatches() {
        return sixMatches;
    }

    public double getRate() {
        return rate;
    }
}
