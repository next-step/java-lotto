package step2.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    NONE(0, 0);

    public int matchNumber;
    public long winnings;

    Rank(int matchNumber, long winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public static Rank createRank(int matchCount) {
        if (!isContains(matchCount)) {
            return Rank.NONE;
        }

        return Arrays.stream(Rank.values())
                .filter(m -> m.matchNumber == matchCount)
                .findFirst()
                .get();
    }

    public static boolean isContains(int matchCount) {
        final List<Rank> rankList = Arrays.asList(Rank.values());
        final List<Integer> matchNumbers = rankList.stream()
                .map(o -> o.matchNumber)
                .collect(Collectors
                        .toList());

        return matchNumbers.contains(matchCount);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(matchNumber)
                .append("개 일치(")
                .append(winnings)
                .append("원)")
                .toString();
    }
}
