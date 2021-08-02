package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(List<Lotto> lottos) {
        if(lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException("값이 null이거나 비어있습니다.");
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
