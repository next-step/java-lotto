package lotto.type;

import lotto.Lotto;
import lotto.WinningAmount;
import lotto.WinningNumber;
import lotto.rule.*;

import java.util.*;

/**
 * 당첨 등수
 * 5등부터 1등까지 있고 2등은 없습니다.
 * 미당첨을 의미하는 NONE도 존재합니다.
 */
public enum WinningLevel {
    NONE(0, 0, NoneRule.getInstance()),
    FIFTH(5, 5000, FifthRule.getInstance()),
    FOURTH(4, 50000, FourthRule.getInstance()),
    THIRD(3, 1500000, ThirdRule.getInstance()),
    SECOND(2, 30000000, SecondRule.getInstance()),
    FIRST(1, 2000000000, FirstRule.getInstance());

    private final int level;
    private final WinningAmount amount;
    private final WinningRule rule;

    WinningLevel(int winningLevel, int winningAmount, WinningRule winningRule) {
        this.level = winningLevel;
        this.amount = WinningAmount.of(winningAmount);
        this.rule = winningRule;
    }

    public static WinningLevel of(int winningLevel) {
        return WinningLevelTable.convert(winningLevel);
    }

    public static WinningLevel decideFinalWinningLevel(Lotto lotto, WinningNumber winningNumber) {
        List<WinningLevel> matchedRule = new ArrayList<>();

        for (WinningLevel level : WinningLevel.values()) {
            addIfRuleMatched(lotto, winningNumber, level, matchedRule);
        }

        return matchedRule.get(0);
    }

    private static void addIfRuleMatched(Lotto lotto, WinningNumber winningNumber, WinningLevel level, List<WinningLevel> matchedRule) {
        if (level.isMatched(lotto, winningNumber)) {
            matchedRule.add(level);
        }
    }

    public boolean isMatched(Lotto lotto, WinningNumber winningNumber) {
        return this.rule.isMatched(lotto, winningNumber);
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
