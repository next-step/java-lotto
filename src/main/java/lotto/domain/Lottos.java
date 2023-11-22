package lotto.domain;

import java.util.HashMap;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;
    private WinningFinder finder;

    public Lottos(List<Lotto> lottoList, List<Integer> winningLottoNumbers) {
        this.lottoList = lottoList;
        finder = new WinningFinder(new Lotto(winningLottoNumbers).getNumbers());
    }

    public Lottos(List<Lotto> lottoList, List<Integer> winningLottoNumbers, Integer bonusNumber) {
        this.lottoList = lottoList;
        finder = new WinningFinder(new Lotto(winningLottoNumbers).getNumbers(), bonusNumber);
    }

    public HashMap<WinningAmount, Integer> countAllWinning() {
        for (Lotto lotto : lottoList) {
            finder.countWinning(lotto);
        }
        return finder.findWinningLottos();
    }
}
