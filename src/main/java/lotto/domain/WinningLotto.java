package lotto.domain;

import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(Lotto lotto, Number bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(Lotto userLotto) {
        return Rank.valueOf((int) userLotto.values().stream()
                .filter(lotto::contains)
                .count()
                , userLotto.contains(bonusNumber));
    }

    public Ranks ranks(Lottos lottos) {
        return new Ranks(lottos.values().stream()
                .map(this::rank)
                .collect(Collectors.toList())
        );
    }
}
