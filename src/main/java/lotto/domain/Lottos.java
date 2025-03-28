package lotto.domain;

import lotto.enums.Rank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(int lottoCount) {
        this.values = Stream.generate(Lotto::new)
                .limit(lottoCount)
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

    public List<Lotto> getValues() {
        return this.values;
    }
}
