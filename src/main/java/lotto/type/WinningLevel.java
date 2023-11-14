package lotto.type;

/**
 * 당첨 등수
 * 5등부터 1등까지 있고 2등은 없습니다.
 * 미당첨을 의미하는 NONE도 존재합니다.
 */
public enum WinningLevel {
    NONE(0),
    FIVE(5),
    FOUR(4),
    THREE(3),
    ONE(1);

    private final int winningLevel;

    WinningLevel(int winningLevel) {
        this.winningLevel = winningLevel;
    }

    public static WinningLevel of(int winningLevel) {
        if (winningLevel == 0) {
            return WinningLevel.NONE;
        }

        if (winningLevel == 5) {
            return WinningLevel.FIVE;
        }

        if (winningLevel == 4) {
            return WinningLevel.FOUR;
        }

        if (winningLevel == 3) {
            return WinningLevel.THREE;
        }

        if (winningLevel == 1) {
            return WinningLevel.ONE;
        }

        throw new IllegalArgumentException("알 수 없는 등수: " + winningLevel);
    }
}
