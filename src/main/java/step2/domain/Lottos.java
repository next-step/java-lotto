package step2.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public boolean isLottoTicketsCount(int size) {
        return lottos.size() == size;
    }
}
