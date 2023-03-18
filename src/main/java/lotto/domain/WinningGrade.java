package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum WinningGrade {
    FIRST_PRIZE(1, 6, false, false, new Money(2000000000)),
    SECOND_PRIZE(2, 5, true, true, new Money(30000000)),
    THIRD_PRIZE(3, 5, true, false, new Money(1500000)),
    FORTH_PRIZE(4, 4, false, false, new Money(50000)),
    FIFTY_PRIZE(5, 3, false, false, new Money(5000)),
    ETC(0, 0, false, false, Money.ZERO),
    ;

    private final int grade;
    private final int matchCount;
    private final boolean isNeedBonusMatch;
    private final boolean isBonusMatch;
    private final Money winningMoney;

    WinningGrade(int grade, int matchCount, boolean isNeedBonusMatch, boolean isBonusMatch, Money winningMoney) {
        this.grade = grade;
        this.matchCount = matchCount;
        this.isNeedBonusMatch = isNeedBonusMatch;
        this.isBonusMatch = isBonusMatch;
        this.winningMoney = winningMoney;
    }

    public static WinningGrade from(int matchCount, boolean contains) {
        List<WinningGrade> matchGrades = Arrays.stream(WinningGrade.values())
                .filter(winningGrade -> winningGrade.matchCount == matchCount)
                .collect(Collectors.toList());

        if (matchGrades.size() == 1) {
            return matchGrades.stream().findFirst().get();
        }

        Optional<WinningGrade> result = matchGrades.stream().filter(winningGrade -> winningGrade.isNeedBonusMatch)
                .filter(winningGrade -> winningGrade.isBonusMatch == contains)
                .findFirst();
        return result.orElse(WinningGrade.ETC);
    }

    public Integer getPrizeMoney() {
        return this.winningMoney.toInteger();
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isNeedBonusMatch() {
        return isNeedBonusMatch;
    }
}
