package lotto.service;

public enum LottoRankCalculator {
    FIRST(1),
    SECOND(2),
    THIRD(3),
    FOURTH(4),
    FIFTH(5),
    MISS(0);

    private int rank;

    private LottoRankCalculator(int rank) {
        this.rank = rank;
    }

    public static int determineRank (int matchingCount, boolean isMatchBonus) {
        return (matchingCount == 6) ? FIRST.rank :
                (matchingCount == 5) ? (isMatchBonus ? SECOND.rank : THIRD.rank) :
                        (matchingCount == 4) ? (!isMatchBonus ? FOURTH.rank : FIFTH.rank) :
                                (matchingCount == 3) ? (!isMatchBonus ? FIFTH.rank : MISS.rank) :
                                        MISS.rank;
    }

}