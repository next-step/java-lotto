package lotto.model;

import lotto.util.BunchOfLottoGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BunchOfLotto {
    private final List<Lotto> bunchOfLotto;

    public BunchOfLotto(int purchasedLottoCount) {
        this.bunchOfLotto = BunchOfLottoGenerator.makeBunchOfLotto(purchasedLottoCount);
    }

    public BunchOfLotto() {
        this.bunchOfLotto = new ArrayList<>();
    }

    public List<Lotto> getBunchOfLotto() {
        return Collections.unmodifiableList(bunchOfLotto);
    }

    public Prizes makeRewards(WinningLotto winningLotto) {
        List<Reward> prizes = bunchOfLotto.stream()
                .map(lotto -> Reward.getReward(winningLotto.makeWinningCount(lotto.getLottoNumbers()), winningLotto.checkBonusCount(lotto)))
                .collect(Collectors.toList());

        return new Prizes(prizes);
    }
}
