package step2.domain.statistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    public int matchNumber;
    public long winnings;

    Rank(int matchNumber, long winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public static Rank rank(int matchCount, boolean bonusContained) {
        if (!isContains(matchCount)) {
            return Rank.NONE;
        }

        if (Rank.SECOND.matchNumber == matchCount && bonusContained) {
            return Rank.SECOND;
        }

        if (Rank.THIRD.matchNumber == matchCount && !bonusContained) {
            return Rank.THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(r -> r.matchNumber == matchCount)
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
        final StringBuilder output = new StringBuilder()
                .append(matchNumber).append("개 일치");

        if (this.equals(Rank.SECOND)) {
            output.append(", 보너스 볼 일치");
        }

        output.append(" (").append(winnings).append("원)");
        return output.toString();
    }
}
