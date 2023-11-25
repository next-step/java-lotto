package lotto;

import java.util.List;

public class LottoStatics {

    private WinningLottos winningLottos;

    public LottoStatics() {
    }

    public WinningLottos classifyRankLotto(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusBall) {
        winningLottos = new WinningLottos();
        for (Lotto lotto : lottos) {
            int matchingCount = winningLotto.countMatchingWinningLotto(lotto);
            winningLottos.putWinningMatchingNumberLotto(matchingCount, lotto.matchLottoNumber(bonusBall));
        }
        return winningLottos;
    }

    public Integer rewardTotalWinningLottos() {
        return winningLottos.totalRewardWinningLottos();
    }

}
