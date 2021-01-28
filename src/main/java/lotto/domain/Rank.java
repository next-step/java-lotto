package lotto.domain;

public enum Rank {

    FIRST(6, "6개 일치", "2000000000원"),
    SECOND(6, "5개 일치, 보너스 볼 일치", "30000000원"),
    THIRD(5, "5개 일치", "1500000원"),
    FOURTH(4, "4개 일치", "50000원"),
    FIFTH(3, "3개 일치", "5000원"),
    ;

    private final int count;
    private final String matchCount;
    private final String amount;

    Rank(final int count, final String matchCount, final String amount) {
        this.count = count;
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Rank of(final int count) {
        switch (count) {
            case 6:
                return Rank.FIRST;
            case 5:
                return Rank.FIRST;
            case 4:
                return Rank.FOURTH;
            case 3:
                return Rank.FIFTH;
            default:
                return Rank.FIFTH;
        }
    }
}