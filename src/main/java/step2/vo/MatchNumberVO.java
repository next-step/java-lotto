package step2.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum MatchNumberVO {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    public int matchNumber;
    public long winnings;

    MatchNumberVO(int matchNumber, long winnings) {
        this.matchNumber = matchNumber;
        this.winnings = winnings;
    }

    public static boolean isContains(int matchCount) {
        final List<MatchNumberVO> matchNumberVOList = Arrays.asList(MatchNumberVO.values());
        final List<Integer> matchNumbers = matchNumberVOList.stream()
                .map(o -> o.matchNumber)
                .collect(Collectors
                        .toList());

        if (matchNumbers.contains(matchCount)) {
            return true;
        }
        return false;
    }

    public static MatchNumberVO createMatchNumber(int matchCount) {
        final MatchNumberVO findMatchNumberVO = Arrays.stream(MatchNumberVO
                .values())
                .filter(m -> {return m
                        .matchNumber == matchCount;
                }).findFirst()
                .get();
        return findMatchNumberVO;
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
