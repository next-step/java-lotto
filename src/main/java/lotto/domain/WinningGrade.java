package lotto.domain;

public enum WinningGrade {
    FIRST_PRIZE(new Grade(1), new WinningGradeDescription("6개 일치", new Money(2000000000))),
    SECOND_PRIZE(new Grade(2), new WinningGradeDescription("5개 일치, 보너스 볼 일치", new Money(30000000))),
    THIRD_PRIZE(new Grade(3), new WinningGradeDescription("5개 일치", new Money(1500000))),
    FORTH_PRIZE(new Grade(4), new WinningGradeDescription("4개 일치", new Money(50000))),
    FIFTY_PRIZE(new Grade(5), new WinningGradeDescription("3개 일치 (5000원)", new Money(5000))),
    ETC(new Grade(0), new WinningGradeDescription()),;

    private final Grade prizeGrade;
    private final WinningGradeDescription winningGradeDescription;

    WinningGrade(Grade prizeGrade, WinningGradeDescription winningGradeDescription) {
        this.prizeGrade = prizeGrade;
        this.winningGradeDescription = winningGradeDescription;
    }

    public static WinningGrade checkWinningGrade(int matchWinningCount, boolean matchBonus) {
        if (matchWinningCount == 6) {
            return FIRST_PRIZE;
        }

        if (matchWinningCount == 5 && matchBonus) {
            return SECOND_PRIZE;
        }

        if (matchWinningCount == 5) {
            return THIRD_PRIZE;
        }

        if (matchWinningCount == 4) {
            return FORTH_PRIZE;
        }

        if (matchWinningCount == 3) {
            return FIFTY_PRIZE;
        }

        return ETC;
    }

    public Integer getPrizeMoney() {
        return this.winningGradeDescription.getIntegerPrizeMoney();
    }

    public String getDescriptionForPrint() {
        return this.winningGradeDescription + "(" + this.getPrizeMoney() + "원)";
    }
}
