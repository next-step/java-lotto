package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {

    private final LottoMachine lottoMachine;

    public Store() {
        lottoMachine = new LottoMachine();
    }

    public IssuedLottos issueLottos(final int amount) {
        final int count = amount / 1000;

        final List<Lotto> issuedLottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto issuedLotto = lottoMachine.issue();
            issuedLottos.add(issuedLotto);
        }

        return new IssuedLottos(issuedLottos);
    }
}
