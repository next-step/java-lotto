package lotto.domain;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MatchCount {

    FIRST(6, 2_000_000_000)
    , SECOND(5, 1_500_000)
    , THIRD(4, 50_000)
    , FORTH(3, 5_000)
    , MISS(0, 0)
    ;

    private static final Map<Integer, Integer> matchPriceInfo;
    static {
        matchPriceInfo = Stream.of(MatchCount.values())
              .filter(matchCount -> !MISS.equals(matchCount))
              .collect(Collectors.toMap(matchCount -> matchCount.matchCount, matchCount -> matchCount.priceMoney));
    }

    private int matchCount;
    private int priceMoney;

    MatchCount(int matchCount, int priceMoney) {
        this.matchCount = matchCount;
        this.priceMoney = priceMoney;
    }

    public static TreeMap<Integer, Integer> result(Map<Integer, Integer> matchCounts) {
        return matchPriceInfo.keySet().stream()
              .collect(Collectors.toMap(Function.identity(), matchCount -> matchCounts
                    .getOrDefault(matchCount, 0), Integer::sum, TreeMap::new));
    }

    public static int priceMoney(int matchCount) {
        return matchPriceInfo.getOrDefault(matchCount, MISS.priceMoney);
    }

}
