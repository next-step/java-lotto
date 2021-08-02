package lotto.domain;

public enum Rank {
    FIRST(6, 2000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    MISS(0, 0);

    private final int hitCount;
    private final int winningMoney;
    private static final int MIN_HITS_COUNT = 0;
    private static final int MAX_HITS_COUNT = 6;
    private static final String OUT_OF_BOUNDS_ERROR_MESSAGE = "맞춘 횟수는 0에서 6 사이여야 합니다.";

    Rank(int hitCount, int winningMoney) {
        this.hitCount = hitCount;
        this.winningMoney = winningMoney;
    }

    public static int inquireWinningMoney(int hitsCount) {
        validateHitsCount(hitsCount);

        for(Rank rank : values()) {
            if(hitsCount == rank.getHitCount()) {
                return rank.getWinningMoney();
            }
        }
        return 0;
    }

    public static Rank returnRank(int hitsCount) {
        validateHitsCount(hitsCount);
        for(Rank rank : values()) {
            if(hitsCount == rank.getHitCount()) {
                return rank;
            }
        }
        return MISS;
    }

    private static void validateHitsCount(int hitsCount) {
        if(hitsCount < MIN_HITS_COUNT || hitsCount > MAX_HITS_COUNT) {
            throw new IllegalArgumentException(OUT_OF_BOUNDS_ERROR_MESSAGE);
        }
    }

    public int getHitCount() {
        return this.hitCount;
    }

    public int getWinningMoney() {
        return this.winningMoney;
    }

}
