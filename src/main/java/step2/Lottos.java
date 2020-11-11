package step2;

import java.util.Collections;
import java.util.List;

public class Lottos {
    public static Lottos EMPTY = Lottos.of(Collections.emptyList());
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }
    public int size() {
        return lottos.size();
    }
}
