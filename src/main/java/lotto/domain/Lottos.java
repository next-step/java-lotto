package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos() {}

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public int getNumberOfLotto() {
        return lottoList.size();
    }

    public HashMap<WinningAmount, Integer> countAllWinning(List<Integer> winningNumber) {
        WinningLottoManager winningManager = new WinningLottoManager(winningNumber);
        for (Lotto lotto : lottoList) {
            winningManager.countWinning(lotto);
        }
        return winningManager.findWinningLottos();
    }
}
