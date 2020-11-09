package step2.type;

import java.util.stream.Stream;

public enum WinningType {
    RANK_ONE(6, 2000000000),
    RANK_TWO(5, 1500000),
    RANK_THREE(4, 50000),
    RANK_FOUR(3, 5000),
    RANK_ETC(2, 0);

    private final int matchCount;
    private final int winningAmount;

    WinningType(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public static WinningType getType(int matchCount) {
        return Stream.of(WinningType.values())
                .filter(type -> WinningType.match(type.matchCount, matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private static boolean match(int source, int target) {
        int etcCount = RANK_ETC.matchCount;
        if (source == etcCount && target <= etcCount) {
            return true;
        }
        return source == target;
    }

    public static int getMatchCount(WinningType type) {
        return type.matchCount;
    }

    public static long getWinningAmount(WinningType type) {
        return type.winningAmount;
    }
}
