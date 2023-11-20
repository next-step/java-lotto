package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;
    private Lotto winningLotto;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public Lottos(List<Lotto> lottoList, List<Integer> winningLottoNumbers) {
        this.lottoList = lottoList;
        winningLotto = new Lotto(winningLottoNumbers);
    }

    public HashMap<WinningAmount, Integer> countAllWinning() {
        WinningFinder winningManager = new WinningFinder(winningLotto.getNumbers());
        for (Lotto lotto : lottoList) {
            winningManager.countWinning(lotto);
        }
        return winningManager.findWinningLottos();
    }
}
