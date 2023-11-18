package lotto;

import java.util.List;

public class LottoStatics {

    private WinningLottos winningLottos = new WinningLottos();

    public void classifyRankLotto(List<Lotto> lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchingCount = winningLotto.countMatchingWinningLotto(lotto);
            winningLottos.putWinningMatchingNumberLotto(matchingCount);
        }
    }

    public Integer matchCountRanks(int count) {
        return winningLottos.countLottoByWinningNumber(count);
    }
}
