package lotto;

import java.util.List;

public class LottoStatics {

    private WinningLottos winningLottos = new WinningLottos();

    public LottoStatics() {
    }

    public LottoStatics(WinningLottos winningLottos) {
        this.winningLottos = winningLottos;
    }

    public void classifyRankLotto(List<Lotto> lottos, Lotto winningLotto, LottoNumber bonusBall) {
        for (Lotto lotto : lottos) {
            int matchingCount = winningLotto.countMatchingWinningLotto(lotto);
            winningLottos.putWinningMatchingNumberLotto(matchingCount, lotto.matchBonusNumber(bonusBall));
        }
    }

    public Integer matchCountRanks(int count, boolean matchBonus) {
        return winningLottos.countLottoByWinningNumber(count, matchBonus);
    }

    public Integer rewardWinningLotto(int count, boolean matchBonus) {
        return winningLottos.rewardWinningLotto(count, matchBonus);
    }

    public Integer rewardTotalWinningLottos() {
        return winningLottos.totalRewardWinningLottos();
    }

    public WinningLottos winningLottos() {
        return winningLottos;
    }
}
