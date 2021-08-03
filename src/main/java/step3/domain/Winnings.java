package step3.domain;

public enum Winnings {
    NOTHING(0, 0),
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private int matchCount;
    private int price;

    Winnings(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static int findPrice(int count) {
        for (Winnings WIN : values()) {
            if (WIN.matchCount == count) {
                return WIN.price;
            }
        }
        return NOTHING.price;
    }

    public static Winnings find(int count) {
        for (Winnings WIN : values()) {
            if (WIN.matchCount == count) {
                return WIN;
            }
        }
        return NOTHING;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }
}
