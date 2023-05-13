package autolotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public enum Winning {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    static private final Map<Integer, Winning> winningsMap = new HashMap<>();

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

    public static Winning winningOf(int matchCount) {
        return Optional.ofNullable(winningsMap.get(matchCount))
                .orElseThrow(() -> new IllegalArgumentException("2개 이하는 당첨금을 받을 수 없습니다"));
    }

    public int winningMoney() {
        return this.winningMoney;
    }
}
