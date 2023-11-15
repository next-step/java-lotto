package lotto;

import lotto.type.WinningLevel;

import java.util.HashMap;
import java.util.Map;

/**
 * 당첨 등수와 상금간의 매핑용 테이블입니다.
 */
public class WinningLevelToAmountTable {
    private final Map<WinningLevel, WinningAmount> winningAmountTable;

    private WinningLevelToAmountTable() {
        winningAmountTable = new HashMap<>();
        winningAmountTable.put(WinningLevel.NONE, WinningAmount.of(0));
        winningAmountTable.put(WinningLevel.FIFTH, WinningAmount.of(5000));
        winningAmountTable.put(WinningLevel.FOURTH, WinningAmount.of(50000));
        winningAmountTable.put(WinningLevel.THIRD, WinningAmount.of(1500000));
        winningAmountTable.put(WinningLevel.FIRST, WinningAmount.of(2000000000));
    }

    private static WinningLevelToAmountTable getInstance() {
        return new WinningLevelToAmountTable();
    }

    /**
     * 등수와 매칭되는 상금을 가져옵니다.
     *
     * @param winningLevel 당첨 등수값
     * @return 그 당첨 등수에 해당하는 상금
     */
    public static WinningAmount convert(WinningLevel winningLevel) {
        boolean contain = WinningLevelToAmountTable.getInstance().winningAmountTable.containsKey(winningLevel);

        if (!contain) {
            throw new IllegalArgumentException("알 수 없는 등수: " + winningLevel);
        }

        return WinningLevelToAmountTable.getInstance().winningAmountTable.get(winningLevel);
    }
}
