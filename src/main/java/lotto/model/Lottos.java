package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Lottos {

    private final List<Lotto> lottos;

    protected Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public RankResults matchWinningNumbers(final WinningNumbers winningNumbers) {
        return new RankResults(lottos.stream()
                .map(winningNumbers::checkRank)
                .collect(Collectors.toUnmodifiableList()));
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
    }
}
