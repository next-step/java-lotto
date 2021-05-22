package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final Money money;

    public LottoMachine(Money money) {
        this.money = money;
    }

    public Lottos pullSlot() {
        int lottoCount = money.getLottoCount();
        List<Lotto> lottos = new ArrayList<>(lottoCount);
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return new Lottos(lottos);
    }
}
