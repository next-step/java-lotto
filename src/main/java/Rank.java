public enum Rank {
    UNRANKED(0),
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000);

    private final int money;

    Rank(int money) {
        this.money = money;
    }

    // enum형이라 getter 쓸만하지 않을까? DTO 느낌으로..
    public int getMoney() {
        return money;
    }

    public static Rank from(boolean bonusMatched, MatchCount matchCount) {
        if (matchCount.is(6)) {
            return Rank.FIRST;
        }
        if(matchCount.is(5) && bonusMatched) {
            return Rank.SECOND;
        }
        if (matchCount.is(5)) {
            return Rank.THIRD;
        }
        if (matchCount.is(4)) {
            return Rank.FOURTH;
        }
        if (matchCount.is(3)) {
            return Rank.FIFTH;
        }

        return Rank.UNRANKED;
    }
}
