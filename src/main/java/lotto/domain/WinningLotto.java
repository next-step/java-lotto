package lotto.domain;

import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;
    private final Number bonusNumber;

    public WinningLotto(Lotto lotto, Number bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Rank rank(Lotto userLotto) {
        return Rank.valueOf((int) userLotto.numbers().stream()
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
