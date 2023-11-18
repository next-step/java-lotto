package lotto.type;

import lotto.WinningAmount;

import java.util.HashMap;
import java.util.Map;

/**
 * 당첨 등수
 * 5등부터 1등까지 있고 2등은 없습니다.
 * 미당첨을 의미하는 NONE도 존재합니다.
 */
public enum WinningLevel {
    NONE(0, 0),
    FIFTH(5, 5000),
    FOURTH(4, 50000),
    THIRD(3, 1500000),
    SECOND(2, 30000000),
    FIRST(1, 2000000000);

    private final int level;
    private final WinningAmount amount;

    WinningLevel(int winningLevel, int winningAmount) {
        this.level = winningLevel;
        this.amount = WinningAmount.of(winningAmount);
    }

    public static WinningLevel of(int winningLevel) {
        return WinningLevelTable.convert(winningLevel);
    }

    public WinningAmount getAmount() {
        return this.amount;
    }
}

class WinningLevelTable {
    private static WinningLevelTable instance;

    private final Map<Integer, WinningLevel> winningLevelTable;
    
    private WinningLevelTable() {
        winningLevelTable = new HashMap<>();
        winningLevelTable.put(0, WinningLevel.NONE);
        winningLevelTable.put(5, WinningLevel.FIFTH);
        winningLevelTable.put(4, WinningLevel.FOURTH);
        winningLevelTable.put(3, WinningLevel.THIRD);
        winningLevelTable.put(2, WinningLevel.SECOND);
        winningLevelTable.put(1, WinningLevel.FIRST);
    }

    private static WinningLevelTable getInstance() {
        if (instance == null) {
            instance = new WinningLevelTable();
        }

        return instance;
    }

    /**
     * 정수 원시값으로 되어 있는 등수를 WinningLevel의 등수로 매핑 변환합니다.
     * @param winningLevel 정수 등수값
     * @return WinningLevel로 변환된 등수값
     */
    public static WinningLevel convert(int winningLevel) {
        boolean contain = WinningLevelTable.getInstance().winningLevelTable.containsKey(winningLevel);

        if (!contain) {
            throw new IllegalArgumentException("알 수 없는 등수: " + winningLevel);
        }

        return WinningLevelTable.getInstance().winningLevelTable.get(winningLevel);
    }
}
