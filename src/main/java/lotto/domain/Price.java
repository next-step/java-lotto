package lotto.domain;

public enum Price {

    LOTTO(1000);

    private final int value;

    Price(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public int multiple(SelfIssueCount count) {
        return count.getCount() * value;
    }

    public int divide(int budget) {
        return budget / value;
    }
}