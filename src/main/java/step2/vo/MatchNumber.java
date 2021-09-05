package step2.vo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum MatchNumber {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int matchNumber;
    public long winnings;

    MatchNumber(int matchNumber, long winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public static boolean isContains(int matchCount) {
        final List<MatchNumber> matchNumberList = Arrays.asList(MatchNumber.values());
        final List<Integer> matchNumbers = matchNumberList.stream()
                .map(o -> o.matchNumber)
                .collect(Collectors
                        .toList());

        return matchNumbers.contains(matchCount);
    }

    public static MatchNumber createMatchNumber(int matchCount) {
        return Arrays.stream(MatchNumber.values())
                .filter(m -> m.matchNumber == matchCount)
                .findFirst()
                .get();
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
