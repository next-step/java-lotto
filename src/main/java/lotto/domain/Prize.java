package lotto.domain;

public enum Prize {

    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    FIVE_WITH_BONUS(5, 30000000),
    SIX(6, 2000000000);

    private final int matchedNumber;
    private final int cash;

    Prize(final int matchedNumber, final int cash) {
        this.matchedNumber = matchedNumber;
        this.cash = cash;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getCash() {
        return cash;
    }

    @Override
    public String toString() {
        return "Prize{" +
            "matchedNumber=" + matchedNumber +
            ", cash=" + cash +
            '}';
    }
}
