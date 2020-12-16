package lotto.domain;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MatchCount {

    FIRST(6, 2_000_000_000)
    , SECOND_WITH_BONUS(5, 30_000_000)
    , SECOND(5, 1_500_000)
    , THIRD(4, 50_000)
    , FORTH(3, 5_000)
    , MISS(0, 0)
    ;

    private static final Map<Integer, MatchCount> matchPriceInfo;
    static {
        matchPriceInfo = Stream.of(MatchCount.values())
              .filter(matchCount -> !MISS.equals(matchCount) && !SECOND_WITH_BONUS.equals(matchCount))
              .collect(Collectors.toMap(matchCount -> matchCount.matchCount, matchCount -> matchCount));
    }

    private int matchCount;
    private int priceMoney;

    MatchCount(int matchCount, int priceMoney) {
        this.matchCount = matchCount;
        this.priceMoney = priceMoney;
    }

    public static MatchCount getResult(int matchCount, boolean isBonusMatch) {
        if (SECOND.matchCount == matchCount) {
            return isBonusMatch ? SECOND_WITH_BONUS : SECOND;
        }

        return matchPriceInfo.getOrDefault(matchCount, MISS);
    }

    public static Map<MatchCount, Integer> result(Map<MatchCount, Integer> matchCounts) {
        return Stream.of(MatchCount.values())
              .filter(matchCount -> !MISS.equals(matchCount))
              .collect(Collectors.toMap(Function.identity(), matchCount -> matchCounts
                    .getOrDefault(matchCount, 0), Integer::sum));
    }

    public int calculatePriceMoney(int ticketCount) {
        return this.priceMoney * ticketCount;
    }

    public String printMessage(int ticketCount) {
        if (MatchCount.SECOND_WITH_BONUS.equals(this)) {
            return this.matchCount + "개 일치, 보너스 볼 일치(" + this.priceMoney + "원) - " + ticketCount + "개";
        }

        return this.matchCount + "개 일치 (" + this.priceMoney + "원) - " + ticketCount + "개";
    }

    public int getMatchCount() {
        return matchCount;
    }
}
