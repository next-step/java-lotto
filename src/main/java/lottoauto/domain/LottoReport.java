package lottoauto.domain;

public class LottoReport {

    private int firstWinningCount = 0;
    private int secondWinningCount = 0;
    private int thirdWinningCount = 0;
    private int fourthWinningCount = 0;
    private int fifthWinningCount = 0;
    private long profitRate;

    public LottoReport(int fifthWinningCount, int fourthWinningCount, int thirdWinningCount, int secondWinningCount, int firstWinningCount, int profitRate) {
        this.fifthWinningCount = fifthWinningCount;
        this.fourthWinningCount = fourthWinningCount;
        this.thirdWinningCount = thirdWinningCount;
        this.secondWinningCount = secondWinningCount;
        this.firstWinningCount = firstWinningCount;
        this.profitRate = profitRate;
    }

    public int getFirstWinningCount() {
        return firstWinningCount;
    }

    public int getSecondWinningCount() {
        return secondWinningCount;
    }

    public int getThirdWinningCount() {
        return thirdWinningCount;
    }

    public int getFourthWinningCount() {
        return fourthWinningCount;
    }

    public int getFifthWinningCount() {
        return fifthWinningCount;
    }

    public long getProfitRate() {
        return profitRate;
    }
}
