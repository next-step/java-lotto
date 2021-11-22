package lotto.model;

public enum WinningPrice {
    NOTWIN(0),
    FORTH(5000),
    THIRD(50000),
    SECOND(1500000),
    FIRST(2000000000);

    private final int price;

    WinningPrice(int price) {
        this.price = price;
    }

    public static WinningPrice of(int winningCount) {
        switch (winningCount) {
            case 3:
                return FORTH;
            case 4:
                return THIRD;
            case 5:
                return SECOND;
            case 6:
                return FIRST;
            default:
                return NOTWIN;
        }
    }

    public int getPrice() {
        return price;
    }
}

