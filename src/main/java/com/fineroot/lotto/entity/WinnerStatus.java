package com.fineroot.lotto.entity;

import com.fineroot.lotto.dto.Money;
import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class WinnerStatus {

    private final Map<WinningRank, Integer> winningMap;

    private WinnerStatus() {
        winningMap = new EnumMap<>(Map.of(
                WinningRank.FIRST_PRIZE, 0,
                WinningRank.SECOND_PRIZE, 0,
                WinningRank.THIRD_PRIZE, 0,
                WinningRank.FORTH_PRIZE, 0));
    }

    private WinnerStatus(Map<WinningRank, Integer> winningMap) {
        this.winningMap = winningMap;
    }

    public static WinnerStatus create() {
        return new WinnerStatus();
    }

    public static WinnerStatus from(Map<WinningRank, Integer> winningMap) {
        return new WinnerStatus(winningMap);
    }

    public void increaseWinningCount(WinningRank winningRank) {
        if (winningRank != WinningRank.NONE) {
            int increasedCount = winningMap.get(winningRank) + 1;
            winningMap.put(winningRank, increasedCount);
        }
    }

    public int matchCount(WinningRank winningRank) {
        return winningMap.get(winningRank);
    }

    public double totalEarningRate(Money purchaseMoney) {
        double sum = 0.0d;
        for (Entry<WinningRank, Integer> winningMapEntry : winningMap.entrySet()) {
            sum += winningMapEntry.getKey().getWinnerPrice() * winningMapEntry.getValue();
        }
        return sum / purchaseMoney.getValue();
    }
}
