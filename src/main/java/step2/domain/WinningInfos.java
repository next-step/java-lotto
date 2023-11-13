package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningInfos {

    private List<WinningInfo> winningInfoList = new ArrayList<>();
    private static final int PRICE_PER_LOTTO = LottoMachine.PRICE_PER_LOTTO;

    private final int   totalPurchaseCount;

    public WinningInfos(Lottos lottos) {
        this.totalPurchaseCount = lottos.getLottoCount() * PRICE_PER_LOTTO;
    }

    public List<WinningInfo> winningInfoList() {
        return winningInfoList;
    }

    public void addWinningInfo(WinningInfo winningInfo) {
        this.winningInfoList.add(winningInfo);
    }

    public void removeWinningInfo(WinningInfo winningInfo) {
        this.winningInfoList.remove(winningInfo);
    }

    public int earningMoney() {
        return this.winningInfoList.stream()
                .mapToInt(WinningInfo::earningMoney)
                .sum();
    }

    public double earningRate() {
        return (double) earningMoney() / totalPurchaseCount;
    }
}
