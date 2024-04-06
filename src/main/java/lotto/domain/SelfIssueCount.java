package lotto.domain;

public class SelfIssueCount implements Comparable<SelfIssueCount>{

    private int count;

    public SelfIssueCount(int count) {
        validPositiveValue(count);
        this.count = count;
    }

    private void validPositiveValue(int count) {
        if (count < 0)
            throw new IllegalArgumentException("양수 값만 입력할 수 있습니다: " + count);
    }

    public int getCount() {
        return count;
    }

    public boolean isPositive() {
        return count > 0;
    }

    public SelfIssueCount decrease() {
        return new SelfIssueCount(count - 1);
    }

    @Override
    public int compareTo(SelfIssueCount that) {
        return this.count - that.count;
    }
}
