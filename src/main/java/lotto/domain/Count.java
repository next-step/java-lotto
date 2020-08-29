package lotto.domain;

public class Count {

    private final long count;

    public Count(final long count) {
        this.count = count;
    }

    public long update() {
        return count + 1;
    }

    public long getCount() {
        return count;
    }
}
