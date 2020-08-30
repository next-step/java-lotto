package step4.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private Map winningMap;

    public WinningResult() {
        LottoMap lottoMap = new LottoMap(initWinningMap());
        this.winningMap = lottoMap.getLottoMap();
    }

    private Map initWinningMap() {
        Map winningMap = new EnumMap(WinningPrice.class);
        for (WinningPrice winningPrice : WinningPrice.values()) {
            winningMap.put(winningPrice, 0);
        }
        return winningMap;
    }

    public Map<WinningPrice, Integer> makeWinningMap(List<Lotto> lottoList, WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            putWinningMap(lotto, winningLotto);
        }
        winningMap.remove(WinningPrice.OTHER);
        return winningMap;
    }

    private void putWinningMap(Lotto lotto, WinningLotto winningLotto) {
        WinningPrice winningPrice = getWinnerPrice(lotto, winningLotto);
        winningMap.put(winningPrice, (int) winningMap.get(winningPrice) + 1);
    }

    private WinningPrice getWinnerPrice(Lotto lotto, WinningLotto winningLotto) {
        return WinningPrice.valueOf(winningLotto.winningCount(lotto), winningLotto.matchBonus(lotto));
    }
}
