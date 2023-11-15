package lotto;

public enum RewardPrice {
    MATCH_3(3, 5000),
    MATCH_4(4, 50000),
    MATCH_5(5, 1500000),
    MATCH_6(6, 2000000000);

    RewardPrice(int count, long price) {
        this.count = count;
        this.price = price;
    }

    private final int count;
    private final long price;

    public int getCount() {
        return count;
    }

    public long getPrice() {
        return price;
    }
}
