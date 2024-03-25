package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Statistic {

    FIRST(2_000_000_000, false, 6),
    SECOND(30_000_000, true, 5),
    THIRD(1_500_000, false, 5),
    FOURTH(50_000, false, 4),
    FIFTH(5_000, false, 3),
    MISS(0, false, 0, 1, 2);

    Statistic(int price, boolean bonusRequired, int... matcher) {
        this.price = price;
        this.bonusRequired = bonusRequired;
        this.matchers = Arrays
            .stream(matcher)
            .boxed()
            .collect(Collectors.toList());
    }

    private int price;
    private boolean bonusRequired;
    private List<Integer> matchers;

    public int getPrice() {
        return price;
    }

    public boolean isValidMatcher() {
        return this != MISS;
    }

    public Integer getMatcher() {
        if (isValidMatcher()) {
            return matchers.get(0);
        }
        return 0;
    }

    public boolean isMatch(int featNumberCount) {
        return this.matchers.stream()
            .anyMatch(matcher -> matcher == featNumberCount);
    }

    public boolean isBonusRequired() {
        return this.bonusRequired;
    }

    public static Statistic valueOfMatchNumber(int featNumberCount, boolean bonusMatched) {
        List<Statistic> numberMatchedStatistics = getNumberMatchedStatistic(featNumberCount);

        return getStatisticWithBonusOrNot(numberMatchedStatistics, bonusMatched);
    }

    public static Statistic getStatisticWithBonusOrNot(List<Statistic> statistics, boolean bonusMatched) {
        if (bonusMatched) {
            return getStatisticWithBonus(statistics);
        }
        return getStatisticWithoutBonus(statistics);
    }

    private static List<Statistic> getNumberMatchedStatistic(int featNumberCount) {
        return Arrays.stream(values())
            .filter(statistic -> statistic.isMatch(featNumberCount))
            .collect(Collectors.toList());
    }

    private static Statistic getStatisticWithBonus(List<Statistic> statistics) {
        return statistics.stream()
            .filter(Statistic::isBonusRequired)
            .findFirst()
            .orElseThrow();
    }

    private static Statistic getStatisticWithoutBonus(List<Statistic> statistics) {
        return statistics.stream()
            .filter(statistic -> !statistic.isBonusRequired())
            .findFirst()
            .orElseThrow();
    }
}
