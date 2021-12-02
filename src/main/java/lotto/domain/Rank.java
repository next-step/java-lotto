package lotto.domain;

public enum Rank {
    TRIO(3, 5000),
    QUARTET(4, 50000),
    QUINTET(5, 1500000),
    SEXTET(6, 2000000000);

    private final int count;
    private final int amount;

    Rank(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }

    public int getCount() {
        return count;
    }

    public int getAmount() {
        return amount;
    }

    public static Rank getRank(int count) {
        for (Rank rank : Rank.values()) {
            if (rank.getCount() == count) {
                return rank;
            }
        }
        return null;
    }


}
