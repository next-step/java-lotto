package step2.domain;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

public class WinningResultInfo {
    private final EnumMap<WinningCondition, WinningInfo> winningResultInfo;

    public WinningResultInfo(EnumMap<WinningCondition, WinningInfo> winningResultInfo) {
        this.winningResultInfo = winningResultInfo;
    }

    public Map<WinningCondition, WinningInfo> getWinningResultInfo() {
        return Collections.synchronizedMap(new EnumMap<WinningCondition, WinningInfo>(winningResultInfo));
    }

    public WinningRate calculateRate(Money purchasedAmount) {
        Money totalMoney = new Money();

        for (WinningInfo info : winningResultInfo.values()) {
            totalMoney = totalMoney.addMoney(new Money(info.calculatePrize()));
        }

        return totalMoney.calculatePercent(purchasedAmount);
    }
}
