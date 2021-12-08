package step2.domain;

import step2.dto.WinningCondition;
import step2.dto.WinningInfo;
import step2.dto.WinningRate;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class WinningResultInfo {
    private final EnumMap<WinningCondition, WinningInfo> winningResultInfo;

    public WinningResultInfo(EnumMap<WinningCondition, WinningInfo> winningResultInfo) {
        this.winningResultInfo = winningResultInfo;
    }

    public Map<WinningCondition, WinningInfo> getWinningResultInfo() {
        return Collections.synchronizedMap(new EnumMap<>(winningResultInfo));
    }

    public WinningRate calculateRate(Money purchasedAmount) {
        Money totalMoney = new Money();

        for (WinningInfo info : winningResultInfo.values()) {
            totalMoney = totalMoney.addMoney(new Money(info.calculatePrize()));
        }

        return totalMoney.calculatePercent(purchasedAmount);
    }
}
