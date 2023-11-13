package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Lottos {
    private Map<Integer, List<Lotto>> lottos;

    public Lottos(Map<Integer, List<Lotto>> lottos) {
        this.lottos = lottos;
    }

    public Map<Integer, List<Lotto>> getLottos() {
        return Collections.unmodifiableMap(lottos);
    }
}
