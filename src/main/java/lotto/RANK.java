package lotto;


import java.util.Arrays;

/**
 * 3개 일치 (5000원)- 1개
 * 4개 일치 (50000원)- 0개
 * 5개 일치 (1500000원)- 0개
 * 6개 일치 (2000000000원)- 0개
 * 수익률 = 총 당첨 금액 / 구입 금액
 */
public enum RANK {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    ;

    private final int matchedCount;
    private final long prizeMoney;

    RANK(int matchedCount, long prizeMoney) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    public static long getPrizeMoney(MatchedCount count) {
        return Arrays.stream(RANK.values())
                .filter(rank -> count.isEquals(rank.matchedCount))
                .findFirst()
                .map(rank -> rank.prizeMoney)
                .orElseGet(() -> 0L);
    }

    public static Money receivePrize(MatchedCount count, int number){
        return Arrays.stream(RANK.values())
                .filter(rank -> count.isEquals(rank.matchedCount))
                .findFirst()
                .map(rank -> new Money(rank.prizeMoney * number))
                .orElseGet(() -> new Money(0));
    }
}