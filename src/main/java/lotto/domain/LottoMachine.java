package lotto.domain;

import java.util.*;

public class LottoMachine {
    public Lotties createRandomLotties(Money money) {
        List<Lotto> lotties = new ArrayList<>();

        for(int i = 0; i < money.getLottoCount(); i++) {
            lotties.add(new Lotto(new RandomNumGenerator()));
        }
        return new Lotties(lotties);
    }

}
