package lotto;

public class JudgeResult {

    private final int threeMatchCount;
    private final int fourMatchCount;
    private final int fiveMatchCount;
    private final int sixMatchCount;

    public JudgeResult(int threeMatchCount, int fourMatchCount, int fiveMatchCount,
        int sixMatchCount) {
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
}
