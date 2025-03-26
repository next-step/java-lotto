package lotto.domain;

import lotto.enums.Rank;
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

    public Rewards getResult(WinningNumbers winningNumbers, int bonusNumber) {
        return new Rewards(this.values.stream()
                .map(lotto -> Rank.valueOf(winningNumbers.countNumberMatching(lotto), lotto.matchBonusNumber(bonusNumber)))
                .collect(Collectors.toList()));
    }
}
