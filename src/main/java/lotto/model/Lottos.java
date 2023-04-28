package lotto.model;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Lottos implements Iterable<Lotto> {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        Objects.requireNonNull(lottos);
        if (lottos.isEmpty()) {
            throw new IllegalArgumentException("there are no lottos");
        }
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos of(Lotto... lottos) {
        return new Lottos(List.of(lottos));
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int price() {
        return lottos.size() * Lotto.PRICE;
    }

    public int size() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
