package step2.domain;

public enum Rank {
    POSTION_4(5_000, 3),
    POSTION_3(50_000, 4),
    POSTION_2(1_500_000, 5),
    POSTION_1(2_000_000_000, 6);

    public final int price;
    public final int matchCount;

    Rank(int price, int matchCount) {
        this.price = price;
        this.matchCount = matchCount;
    }
}
