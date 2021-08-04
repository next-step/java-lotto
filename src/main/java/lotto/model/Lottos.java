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

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        lottos.stream()
              .map(Lotto::toString)
              .map(this::appendNewLine)
              .forEach(stringBuilder::append);
        return stringBuilder.toString();
    }

    private String appendNewLine(final String lotto) {
        return lotto + System.lineSeparator();
    }
}
