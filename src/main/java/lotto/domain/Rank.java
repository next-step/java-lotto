package lotto.domain;

public enum Rank {
    TRIO(3, 5_000),
    QUARTET(4, 50_000),
    QUINTET(5, 1_500_000),
    SEXTET(6, 2_000_000_000);

    private final int count;
    private final int amount;

    Rank(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public static Rank getRank(int count) {
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == count) {
                return rank;
            }
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

}
