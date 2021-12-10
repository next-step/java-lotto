package lotto.domain;

import lotto.domain.factory.LottoAutoFactory;
import lotto.domain.lotto.Lotto;

import java.util.ArrayList;
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
        return this.lottos;
    }

    public void addAutoLottos(Number autoCount) {
        LottoAutoFactory factory = new LottoAutoFactory();
        for (int i = 0; i < autoCount.getNumber(); i++) {
            lottos.add(factory.newInstance());
        }
    }
}
