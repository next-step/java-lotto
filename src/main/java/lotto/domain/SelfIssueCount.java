package lotto.domain;

public class SelfIssueCount {

    private int count;

    public SelfIssueCount(int count) {
        this.count = count;
    }

    public int multiple(Price price) {
        return count * price.getValue();
    }

    public boolean isPositive() {
        return count > 0;
    }

    public SelfIssueCount decrease() {
        return new SelfIssueCount(--count);
    }
}
