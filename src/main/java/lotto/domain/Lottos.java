package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public HashMap<WinningAmount, Integer> countAllWinning(List<Integer> winningNumber) {
        WinningFinder winningManager = new WinningFinder(winningNumber);
        for (Lotto lotto : lottoList) {
            winningManager.countWinning(lotto);
        }
        return winningManager.findWinningLottos();
    }
}
