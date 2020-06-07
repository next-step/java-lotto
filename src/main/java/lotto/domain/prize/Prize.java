package lotto.domain.prize;

public enum Prize {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private int match;
    private int price;

    Prize(int match, int price) {
        this.match = match;
        this.price = price;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }

    public int calculateTotalPrice(int winningCount) {
        return this.price * winningCount;
    }

}
