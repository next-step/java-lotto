package lotto.domain;

import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(int lottoCount) {
        List<Lotto> arr = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto();
            ResultView.printLotto(lotto);
            arr.add(lotto);
        }
        this.values = arr;
    }

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public Rewards getResult(WinningNumbers winningNumbers) {
        List<Reward> rewards = new ArrayList<>();
        for (Lotto lotto : this.values) {
            rewards.add(new Reward(winningNumbers.countNumberMatching(lotto)));
        }
        return new Rewards(rewards);
    }
}
