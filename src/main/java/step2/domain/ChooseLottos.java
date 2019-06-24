package step2.domain;

import java.util.List;

public class ChooseLottos {
    private final List<Lotto> lottos;

    public ChooseLottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> receiveLottos(final int quantity) {
        return lottos.subList(0, quantity);
    }
}
