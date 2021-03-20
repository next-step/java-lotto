package lotto.domain;

public enum Rank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int count;
    private final int price;

    Rank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public static Rank rank(int countMatchNumber, boolean bonusBall) {
        MatchRank matchRank = new MatchRank();

        for (Rank rank : values()) {
            matchRank.matching(rank, countMatchNumber);
        }

        matchRank.bonusMatching(bonusBall);

        return matchRank.getMatchRank();
    }
}
