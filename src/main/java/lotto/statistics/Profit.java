package lotto.statistics;

public enum Profit {

    PROFIT_MESSAGE("이익"),
    BREAK_EVENT_MESSAGE("본전"),
    LOSS_MESSAGE("손해");

    private final String description;

    Profit(String description) {
        this.description = description;
    }

    public static Profit ratioBy(double ratio) {
        if (ratio > 1) {
            return PROFIT_MESSAGE;
        }
        if (ratio < 1) {
            return LOSS_MESSAGE;
        }
        return BREAK_EVENT_MESSAGE;
    }

    @Override
    public String toString() {
        return description;
    }
}
