package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Lottos {
    private List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public HashMap<WinningAmount, Integer> countAllWinning(WinningLotto winningLotto) {
        for (Lotto lotto : lottoList) {
            winningLotto.countWinning(lotto);
        }
        return winningLotto.sortWinningLottos();
    }

    public void addLottos(Lottos otherLottos) {
        for (Lotto lotto : otherLottos.lottoList) {
            this.lottoList.add(lotto);
        }
    }

    public final List<Lotto> getLottoList() {
        return Collections.unmodifiableList(lottoList);
    }

    public int getLottosSize() {
        return lottoList.size();
    }
}
