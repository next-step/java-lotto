package lotto;

public enum RewardPrice {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_5_WITH_BONUS(5, 30000000),
    MATCH_6(6, 2000000000);

    RewardPrice(int count, int price) {
        this.count = count;
        this.price = price;
    }

    private final int count;
    private final int price;

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }
}
