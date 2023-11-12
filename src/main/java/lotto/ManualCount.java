package lotto;

public class ManualCount {

    private final int count;

    public ManualCount(int count) {
        this.count = count;
    }

    public int count() {
        return this.count;
    }

    public int minus(int countTotal) {
        return countTotal - this.count;
    }
}
