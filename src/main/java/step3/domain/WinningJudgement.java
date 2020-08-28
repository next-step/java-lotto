package step3.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningJudgement {
    private final WinningLotto winningLotto;
    private Map winningMap;

    public WinningJudgement(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    private void initWinningMap() {
        winningMap = new EnumMap(WinningPrice.class);
        for (WinningPrice winningPrice : WinningPrice.values()) {
            winningMap.put(winningPrice, 0);
        }
    }

    public Map<WinningPrice, Integer> makeWinningMap(List<Lotto> lottoList) {
        initWinningMap();
        for (Lotto lotto : lottoList) {
            putWinningMap(lotto);
        }
        winningMap.remove(WinningPrice.OTHER);
        return winningMap;
    }

    private void putWinningMap(Lotto lotto) {
        winningMap.put(WinningPrice.valueOf(winningLotto.winningCount(lotto), winningLotto.matchBonus(lotto)), (int) winningMap.get(WinningPrice.valueOf(winningLotto.winningCount(lotto), winningLotto.matchBonus(lotto))) + 1);
    }
}
