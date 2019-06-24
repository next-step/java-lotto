package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                     .map(Lotto::new)
                     .collect(Collectors.toList());
    }

    public int size() {
        return lottos.size();
    }

    public Lottos add(Lotto lotto) {
        lottos.add(lotto);
        return new Lottos(lottos);
    }
}
