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

    public Prizes makeRewards(WinningLotto winningLotto) {
        return new Prizes(bunchOfLotto.stream()
                .map((lotto) -> Reward.getReward(winningLotto.makeWinningState(lotto)))
                .collect(Collectors.toList()));
    }
}
