package step2.model;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public long getPrice() {
        return lottos.size() * Lotto.PRICE;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }
}