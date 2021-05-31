package lotto.model;

import lotto.util.BunchOfLottoGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BunchOfLotto {
    private final List<Lotto> bunchOfLotto;

    public BunchOfLotto(int purchasedLottoCount) {

        this.bunchOfLotto = BunchOfLottoGenerator.makeBunchOfLotto(purchasedLottoCount);
    }

    public List<Lotto> getBunchOfLotto() {
        return Collections.unmodifiableList(bunchOfLotto);
    }

    public List<Reward> makeRewards(WinningLotto winningLotto){
        WinningLogic winningLogic = new WinningLogic();

        return bunchOfLotto.stream()
                .map((lotto) ->Reward.getReward(winningLogic.makeWinningState(lotto, winningLotto)))
                .collect(Collectors.toList());
    }
}
