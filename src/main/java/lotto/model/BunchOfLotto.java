package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BunchOfLotto {
    private final List<Lotto> bunchOfLotto;

    public BunchOfLotto(BunchOfLotto bunchOfLotto) {
        this.bunchOfLotto = bunchOfLotto.getBunchOfLotto();
    }

    public BunchOfLotto() {
        this.bunchOfLotto = new ArrayList<>();
    }

    public Prizes makeRewards(WinningLotto winningLotto) {
        List<Reward> prizes = bunchOfLotto.stream()
                .map(lotto -> winningLotto.getReward(lotto))
                .collect(Collectors.toList());

        return new Prizes(prizes);
    }

    public void addLotto(Lotto lotto) {
        this.bunchOfLotto.add(lotto);
    }

    public void addBunchOfLotto(BunchOfLotto bunchOfLotto) {
        this.bunchOfLotto.addAll(bunchOfLotto.getBunchOfLotto());
    }

    public List<Lotto> getBunchOfLotto() {
        return Collections.unmodifiableList(bunchOfLotto);
    }
}
