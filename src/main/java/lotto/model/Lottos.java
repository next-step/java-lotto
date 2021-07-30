package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        Objects.requireNonNull(lottos, "lottos must be not null.");
        return new Lottos(lottos);
    }

    public List<LottoPrize> scratch(final WinningLotto winningLotto) {
        validate(winningLotto);
        return lottos.stream()
                     .map(lotto -> lotto.scratch(winningLotto))
                     .collect(toList());
    }

    private void validate(final WinningLotto winningLotto) {
        Objects.requireNonNull(winningLotto, "winningNumbers must be not null.");
        if (!winningLotto.isSizeValid()) {
            throw new IllegalArgumentException("there must be 6 numbers.");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottos.stream().forEach(lotto -> stringBuilder.append(lotto.toString() + System.lineSeparator()));
        return stringBuilder.toString();
    }
}
