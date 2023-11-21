package lotto;

import java.util.List;

public class LottoStatics {

    private WinningLottos winningLottos = new WinningLottos();

    public LottoStatics() {
    }

    public LottoStatics(WinningLottos winningLottos) {
        this.winningLottos = winningLottos;
    }

    public void classifyRankLotto(List<Lotto> lottos, Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int matchingCount = winningLotto.countMatchingWinningLotto(lotto);
            winningLottos.putWinningMatchingNumberLotto(matchingCount);
        }
    }

    public Integer matchCountRanks(int count) {
        return winningLottos.countLottoByWinningNumber(count);
    }

    public Integer rewardWinningLotto(int count) {
        return winningLottos.rewardWinningLotto(count);
    }

    public Integer rewardTotalWinningLottos() {
        return winningLottos.totalRewardWinningLottos();
    }

    public WinningLottos winningLottos() {
        return winningLottos;
    }
}
