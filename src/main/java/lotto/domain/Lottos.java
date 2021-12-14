package lotto.domain;

import lotto.domain.lotto.Lotto;

import java.util.Collections;
import java.util.List;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public void addLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }
}
