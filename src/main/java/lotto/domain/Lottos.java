package lotto.domain;

import java.util.List;

public final class Lottos {

    private static final String IS_NULL_OR_EMPTY_ERROR_MESSAGE = "값이 null이거나 비어있습니다.";

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(final List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new IllegalArgumentException(IS_NULL_OR_EMPTY_ERROR_MESSAGE);
        }
    }

    public int count() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

}
