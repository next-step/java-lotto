package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final int size, final NumbersGenerator numberGenerator) {
        this.lottos = IntStream.range(0, size)
                .mapToObj(count -> new Lotto(numberGenerator.generate()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
