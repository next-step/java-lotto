package lotto.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum MatchNumber {


    NONE(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final Integer count;

    private final Integer money;

    MatchNumber(Integer count, Integer money) {
        this.count = count;
        this.money = money;
    }

    public static MatchNumber getMatchNumber(int count, boolean hasBonusBall) {
        return getMatchNumberByBonusBall(hasBonusBall, getMatchNumberByCount(count));
    }

    private static List<MatchNumber> getMatchNumberByCount(int count) {
        return Arrays.stream(MatchNumber.values())
                .filter((matchNumber -> matchNumber.count == count))
                .sorted(Comparator.comparingInt(MatchNumber::getMoney).reversed())
                .collect(Collectors.toList());
    }

    private static MatchNumber getMatchNumberByBonusBall(boolean hasBonusBall, List<MatchNumber> matchNumbers) {
        int foundMatchNumbers = matchNumbers.size();
        if (foundMatchNumbers == 0) {
            return MatchNumber.NONE;
        }
        if (foundMatchNumbers == 1 || hasBonusBall) {
            return matchNumbers.get(0);
        }
        return matchNumbers.get(1);
    }

    public Integer getCount() {
        return count;
    }

    public Integer getMoney() {
        return money;
    }

}
