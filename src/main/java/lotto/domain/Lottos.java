package lotto.domain;

import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(int lottoCount) {
        this.values = IntStream.range(0, lottoCount)
                .mapToObj(i -> {
                    Lotto lotto = new Lotto();
                    ResultView.printLotto(lotto);
                    return lotto;
                })
                .collect(Collectors.toList());
    }

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public Rewards getResult(WinningNumbers winningNumbers) {
        return new Rewards(this.values.stream()
                .map(value -> new Reward(winningNumbers.countNumberMatching(value)))
                .collect(Collectors.toList()));
    }
}
