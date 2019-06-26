package step2.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ChooseLottos {
    private final List<Lotto> lottos;

    public ChooseLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos.stream()
                     .map(Lotto::new)
                     .collect(Collectors.toList());
    }
}
