package lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(final List<Lotto> lottos) {
        Objects.requireNonNull(lottos, "lottos must be not null.");
        return new Lottos(lottos);
    }

    public Lottos scratch(final WinningNumber winningNumber) {
        validate(winningNumber);
        lottos.forEach(lotto -> lotto.scratch(winningNumber));
        return this;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    private void validate(final WinningNumber winningNumber) {
        Objects.requireNonNull(winningNumber, "winningNumbers must be not null.");
        if (!winningNumber.isSizeValid()) {
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
