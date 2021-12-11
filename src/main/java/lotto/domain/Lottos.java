package lotto.domain;

import lotto.domain.factory.LottoFactory;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    public static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(this.lottos);
    }

    public void addAutoLottos(Number autoCount) {
        for (int i = 0; i < autoCount.getNumber(); i++) {
            lottos.add(LottoFactory.newInstance());
        }
    }
}
