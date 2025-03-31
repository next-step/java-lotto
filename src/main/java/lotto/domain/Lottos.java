package lotto.domain;

import lotto.enums.Rank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> values;

    public Lottos(int lottoCount) {
        this(lottoCount, List.of());
    }

    public Lottos(List<Lotto> values) {
        this(0, values);
    }

    public Lottos(int autoCount, List<Lotto> manualLottoNumbers) {
        this.values = Stream.concat(
                manualLottoNumbers.stream(),
                Stream.generate(Lotto::new).limit(autoCount)
        ).collect(Collectors.toList());
    }

    public Rewards getResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new Rewards(this.values.stream()
                .map(lotto -> Rank.valueOf(winningNumbers.countNumberMatching(lotto), lotto.matchBonusNumber(bonusNumber)))
                .collect(Collectors.toList()));
    }

    public List<Lotto> getValues() {
        return this.values;
    }
}
