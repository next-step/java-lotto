package lotto;

public class LottoResult {
    private int matchedCount;
    private Rank rank;

    public LottoResult(int matchedCount) {
        this.matchedCount = matchedCount;
        this.rank = Rank.getRank(matchedCount);
    }

    public Rank getRank() {
        return rank;
    }

    public int getMatchedCount() {
        return matchedCount;
    }
}
