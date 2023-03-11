package lotto.domain;

public enum WinningGrade {
    FIRST_PRIZE, SECOND_PRIZE, THIRD_PRIZE, FORTH_PRIZE, FIFTY_PRIZE, ETC;

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
}
