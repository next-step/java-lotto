package lottoauto.domain;

public class LottoReport {
    private int matchThreeCount = 0;
    private int matchFourCount = 0;
    private int matchFiveCount = 0;
    private int matchSixCount = 0;
    private int profitRate = 0;

    public LottoReport(int matchThreeCount, int matchFourCount, int matchFiveCount, int matchSixCount, int profitRate) {
        this.matchThreeCount = matchThreeCount;
        this.matchFourCount = matchFourCount;
        this.matchFiveCount = matchFiveCount;
        this.matchSixCount = matchSixCount;
        this.profitRate = profitRate;
    }

    public int getMatchThreeCount() {
        return matchThreeCount;
    }

    public int getMatchFourCount() {
        return matchFourCount;
    }

    public int getMatchFiveCount() {
        return matchFiveCount;
    }

    public int getMatchSixCount() {
        return matchSixCount;
    }

    public int getProfitRate() {
        return profitRate;
    }
}
