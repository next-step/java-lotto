package lotto.domain;

import java.util.Map;

public class WinResult {
    private final int purchasedMoney;
    private final Lottos purchasedLotto;
    private final WinningLotto winningLotto;
    private final Map<WinType, Integer> winResultMap;

    public WinResult(int purchasedMoney, Lottos purchasedLotto, WinningLotto winningLotto) {
        this.purchasedMoney = purchasedMoney;
        this.purchasedLotto = purchasedLotto;
        this.winningLotto = winningLotto;
        this.winResultMap = getWinResultMap();
    }

    public Map<WinType, Integer> getResults() {
        winResultMap.remove(WinType.NO_MATCH);
        return winResultMap;
    }

    public String getYeild() {
        return YieldCalculator.calculateYield(purchasedMoney, winResultMap);
    }

    private Map<WinType, Integer> getWinResultMap() {
        return purchasedLotto.matchWinning(winningLotto);
    }
}
