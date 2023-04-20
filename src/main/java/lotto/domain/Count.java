package lotto.domain;

public class Count {
    private final int count;

    public Count(int count) {
        this.count = count;
    }

    public int getCount() {
        return this.count;
    }

    public Count minus(Count count) {
        return new Count(this.count - count.count);
    }
}
