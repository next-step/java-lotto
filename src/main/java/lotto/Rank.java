package lotto;


import java.util.Arrays;

/**
 * 3개 일치 (5000원)- 1개
 * 4개 일치 (50000원)- 0개
 * 5개 일치 (1500000원)- 0개
 * 6개 일치 (2000000000원)- 0개
 * 수익률 = 총 당첨 금액 / 구입 금액
 */
public enum Rank {

    FIRST(new MatchedCount(6), new Money(2000000000)),
    SECOND(new MatchedCount(5, true), new Money(30000000)),
    THIRD(new MatchedCount(5), new Money(1500000)),
    FOURTH(new MatchedCount(4), new Money(50000)),
    FIFTH(new MatchedCount(3), new Money(5000)),
    ;

    private final MatchedCount matchedCount;
    private final Money prizeMoney;

    Rank(MatchedCount matchedCount, Money prizeMoney) {
        this.matchedCount = matchedCount;
        this.prizeMoney = prizeMoney;
    }

    public static Money getPrizeMoney(MatchedCount count) {
        return Arrays.stream(Rank.values())
                .filter(rank -> count.equals(rank.matchedCount))
                .findFirst()
                .map(rank -> rank.prizeMoney)
                .orElseGet(() -> new Money(0L));
    }

    public static Money receivePrize(MatchedCount count, int number){
        return Arrays.stream(Rank.values())
                .filter(rank -> count.equals(rank.matchedCount))
                .findFirst()
                .map(rank -> rank.prizeMoney.multiply(number))
                .orElseGet(() -> new Money(0));
    }
}