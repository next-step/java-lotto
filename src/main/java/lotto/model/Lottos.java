package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Lottos join(Lottos lottos) {
        return new Lottos(Stream.concat(this.lottos.stream(), lottos.getLottos().stream())
                                .collect(Collectors.toList()));
    }

    public int count() {
        return lottos.size();
    }
}
