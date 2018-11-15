package enums;


public enum LottoReword {
    MISS_MATCH(0, 0),
    ONE_MATCH(1, 0),
    TWO_MATCH(2, 0),
    THREE_MATCH(3, 5_000),
    FOUR_MATCH(4, 50_000),
    FIVE_MATCH(5, 1_500_000),
    FIVE_AND_BONUS_MATCH(5, 30_000_000),
    SIX_MATCH(6, 2_000_000_000);

    private int matchCount;
    private int reword;

    LottoReword(Integer matchCount, int reword) {
        this.matchCount = matchCount;
        this.reword = reword;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReword() {
        return reword;
    }

    public int getReword(int matchCount, boolean matchBonus) {
        LottoReword[] rewords = LottoReword.values();
        if(matchBonus && matchCount == 5) {
            return LottoReword.FIVE_AND_BONUS_MATCH.reword;
        }
        return rewords[matchCount].reword;
    }

    public int computeReward(int numberOfMatches) {
        return this.reword * numberOfMatches;

    }

}
