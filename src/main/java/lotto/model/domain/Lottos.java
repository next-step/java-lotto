package lotto.model.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lottos {

    private static final int START_INCLUSIVE = 0;

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(final int size, final NumbersGenerator numberGenerator) {
        this.lottos = IntStream.range(START_INCLUSIVE, size)
                .mapToObj(count -> new Lotto(numberGenerator.generate()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Rank> matchWinningNumbers(final WinningNumbers winningNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.checkRank(winningNumbers))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
