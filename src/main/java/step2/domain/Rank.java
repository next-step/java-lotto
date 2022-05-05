package step2.domain;

public enum Rank {
    RANK_5(5_000, 3),
    RANK_4(50_000, 4),
    RANK_3(1_500_000, 5),
    RANK_2(30_000_000, 5),
    RANK_1(2_000_000_000, 6);

    public final int price;
    public final int matchCount;

    Rank(int price, int matchCount) {
        this.price = price;
        this.matchCount = matchCount;
    }
}
