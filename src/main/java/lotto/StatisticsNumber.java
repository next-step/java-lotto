package lotto;


public class StatisticsNumber {

    private final int matchedCount;
    private final boolean isBonusNumber;

    public StatisticsNumber(int matchedCount, boolean isBonusNumber) {
        this.matchedCount = matchedCount;
        this.isBonusNumber = isBonusNumber;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusNumber() {
        return isBonusNumber;
    }
}
