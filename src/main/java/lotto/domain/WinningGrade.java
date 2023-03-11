package lotto.domain;

public enum WinningGrade {
    FIRST_PRIZE(2000000000, "6개 일치"),
    SECOND_PRIZE(30000000, "5개 일치, 보너스 볼 일치"),
    THIRD_PRIZE(1500000, "5개 일치"),
    FORTH_PRIZE(50000, "4개 일치"),
    FIFTY_PRIZE(5000, "3개 일치 (5000원)"),
    ETC(0, "");

    private final int prizeMoney;
    private final String description;

    WinningGrade(int prizeMoney, String description) {
        this.prizeMoney = prizeMoney;
        this.description = description;
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
        return this.prizeMoney;
    }

    public String getDescriptionForPrint() {
        return this.description + "(" + this.getPrizeMoney() + "원)";
    }
}
