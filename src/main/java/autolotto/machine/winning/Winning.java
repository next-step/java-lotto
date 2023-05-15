package autolotto.machine.winning;

import java.util.HashMap;
import java.util.Map;

public enum Winning {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
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
        return winningsMap.get(matchCount);
    }

    public int winningMoney() {
        return this.winningMoney;
    }
}
