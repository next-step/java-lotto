package lotto.domain;

import lotto.domain.exception.NullOrEmptyException;

import java.util.List;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        validateLottos(lottos);
        this.lottos = lottos;
    }

    private void validateLottos(final List<Lotto> lottos) {
        if (lottos == null || lottos.isEmpty()) {
            throw new NullOrEmptyException();
        }
    }

    public int count() {
        return lottos.size();
    }




    public List<Lotto> getLottos() {
        return this.lottos;
    }





}
