package lotto.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private static final String IS_NULL_OR_EMPTY_ERROR_MESSAGE = "값이 null이거나 비어있습니다.";

    public Lottos(List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(List<Lotto> lottos) {
        if(lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException(IS_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }
}
