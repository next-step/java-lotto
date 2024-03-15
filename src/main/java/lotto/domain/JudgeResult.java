package lotto.domain;

public class JudgeResult {

    private final int threeMatchCount;
    private final int fourMatchCount;
    private final int fiveMatchCount;
    private final int sixMatchCount;

    public JudgeResult(
        int threeMatchCount, int fourMatchCount, int fiveMatchCount, int sixMatchCount
    ) {
        this.threeMatchCount = threeMatchCount;
        this.fourMatchCount = fourMatchCount;
        this.fiveMatchCount = fiveMatchCount;
        this.sixMatchCount = sixMatchCount;
    }

    public int threeMatchCount() {
        return threeMatchCount;
    }

    public int fourMatchCount() {
        return fourMatchCount;
    }

    public int fiveMatchCount() {
        return fiveMatchCount;
    }

    public int sixMatchCount() {
        return sixMatchCount;
    }

    public double calcReturnRate(Money usedMoney) {
        int returnMoney = (5000 * threeMatchCount) + (50000 * fourMatchCount) + (1500000 * fiveMatchCount) + (2000000000 * sixMatchCount);
        return (double) returnMoney / usedMoney.amount();
    }
}
