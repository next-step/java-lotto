package lotto;

public enum MatchTimes {

    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private final int times;
    private final double price;

    MatchTimes(int times, double price) {
        this.times = times;
        this.price = price;
    }

}
