package lotto.type;

import java.util.HashMap;
import java.util.Map;

/**
 * 당첨 등수
 * 5등부터 1등까지 있고 2등은 없습니다.
 * 미당첨을 의미하는 NONE도 존재합니다.
 */
public enum WinningLevel {
    NONE(0),
    FIFTH(5),
    FOURTH(4),
    THIRD(3),
    FIRST(1);

    private final int winningLevel;

    WinningLevel(int winningLevel) {
        this.winningLevel = winningLevel;
    }

    public static WinningLevel of(int winningLevel) {
        return WinningLevelTable.convert(winningLevel);
    }
}

class WinningLevelTable {
    private final Map<Integer, WinningLevel> winningLevelTable;
    
    private WinningLevelTable() {
        winningLevelTable = new HashMap<>();
        winningLevelTable.put(0, WinningLevel.NONE);
        winningLevelTable.put(5, WinningLevel.FIFTH);
        winningLevelTable.put(4, WinningLevel.FOURTH);
        winningLevelTable.put(3, WinningLevel.THIRD);
        winningLevelTable.put(1, WinningLevel.FIRST);
    }

    private static WinningLevelTable getInstance() {
        return new WinningLevelTable();
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
