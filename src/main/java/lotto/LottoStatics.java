package lotto;

import java.util.List;

public class LottoStatics {

    private WinningLottos winningLottos;

    public LottoStatics() {
    }

    public WinningLottos classifyRankLotto(List<Lotto> lottos, WinningLottoNumbers winningLottoNumbers) {
        winningLottos = new WinningLottos();
        for (Lotto lotto : lottos) {
            winningLottos.putWinningMatchingNumberLotto(winningLottoNumbers.countMatchingWinningLotto(lotto),
                    winningLottoNumbers.matchBonusBall(lotto));
        }
        return winningLottos;
    }

    public Integer rewardTotalWinningLottos() {
        return winningLottos.totalRewardWinningLottos();
    }

}
