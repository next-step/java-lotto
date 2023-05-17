package autolotto.machine.winning;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Winning {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    private static final Map<Integer, Winning> winningsMap = new HashMap<>();

    static {
        for (Winning winning : values()) {
            winningsMap.put(winning.matchNumber, winning);
        }
    }

    private final int matchNumber;
    private final int winningMoney;

    Winning(int matchNumber, int winningMoney) {
        this.matchNumber = matchNumber;
        this.winningMoney = winningMoney;
    }

    public static Winning winningOf(int matchCount, boolean isBonusBallMatched) {
        if (isSecondPrize(matchCount, isBonusBallMatched)) {
            return FIVE_BONUS;
        }

        return Optional.ofNullable(winningsMap.get(matchCount))
                .orElseThrow(() -> new IllegalArgumentException("3개 이상 매칭 될 경우 당첨금이 존재합니다."));
    }

    private static boolean isSecondPrize(int matchCount, boolean isBonusBallMatched) {
        return matchCount == FIVE.matchNumber && isBonusBallMatched;
    }

    public static int minWinningMatchCount() {
        return Winning.THREE.matchNumber;
    }

    public int winningMoney() {
        return this.winningMoney;
    }

    public int matchNumber() {
        return this.matchNumber;
    }
}
