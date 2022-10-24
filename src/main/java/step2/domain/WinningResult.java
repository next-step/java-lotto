package step2.domain;

import java.util.Map;

public class WinningResult {

    private static final double THREE_MATCHES_PRIZE = 5000.0;

    private static final double FOUR_MATCHES_PRIZE = 50000.0;

    private static final double FIVE_MATCHES_PRIZE = 1500000.0;

    private static final double SIX_MATCHES_PRIZE = 20000000000.0;

    private static final int THREE_MATCHES_KEY = 3;

    private static final int FOUR_MATCHES_KEY = 4;

    private static final int FIVE_MATCHES_KEY = 5;

    private static final int SIX_MATCHES_KEY = 6;

    private static final int DEFAULT_MATCH_VALUE = 0;

    private final int threeMatches;

    private final int fourMatches;

    private final int fiveMatches;

    private final int sixMatches;

    private WinningResult(int threeMatches, int fourMatches, int fiveMatches, int sixMatches) {
        this.threeMatches = threeMatches;
        this.fourMatches = fourMatches;
        this.fiveMatches = fiveMatches;
        this.sixMatches = sixMatches;
    }

    public static WinningResult from(Map<Integer, Integer> matchMap) {
        int threeMatches = matchMap.getOrDefault(THREE_MATCHES_KEY, DEFAULT_MATCH_VALUE);
        int fourMatches = matchMap.getOrDefault(FOUR_MATCHES_KEY, DEFAULT_MATCH_VALUE);
        int fiveMatches = matchMap.getOrDefault(FIVE_MATCHES_KEY, DEFAULT_MATCH_VALUE);
        int sixMatches = matchMap.getOrDefault(SIX_MATCHES_KEY, DEFAULT_MATCH_VALUE);
        return new WinningResult(threeMatches, fourMatches, fiveMatches, sixMatches);
    }

    public double getRateOfReturn(int purchasedValue) {
        return (THREE_MATCHES_PRIZE * this.threeMatches
                + FOUR_MATCHES_PRIZE * this.fourMatches
                + FIVE_MATCHES_PRIZE * this.fiveMatches
                + SIX_MATCHES_PRIZE * this.sixMatches) / purchasedValue;
    }

    public int getThreeMatches() {
        return this.threeMatches;
    }

    public int getFourMatches() {
        return this.fourMatches;
    }

    public int getFiveMatches() {
        return this.fiveMatches;
    }

    public int getSixMatches() {
        return this.sixMatches;
    }
}
