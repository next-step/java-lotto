package lotto.domain;

public enum WinningGrade {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FORTH_PRIZE(50000),
    FIFTY_PRIZE(5000),
    ETC(0);

    private final int prizeMoney;

    WinningGrade(int prizeMoney) {
        this.prizeMoney = prizeMoney;
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
}
