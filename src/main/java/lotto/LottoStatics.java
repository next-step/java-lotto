package lotto;

import java.util.List;

public class LottoStatics {

    public LottoStatics() {
    }

    public WinningLottos classifyRankLotto(List<Lotto> lottos, WinningLottoNumbers winningLottoNumbers) {
        WinningLottos winningLottos = new WinningLottos();
        for (Lotto lotto : lottos) {
            winningLottos.putWinningMatchingNumberLotto(winningLottoNumbers.countMatchingWinningLotto(lotto),
                    winningLottoNumbers.matchBonusBall(lotto));
        }
        return winningLottos;
    }

}
