package lotto.domain;

import java.util.*;

public class LottoMachine {
    private final RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

    public Lotties createRandomLotties(Money money) {
        List<Lotto> lotties = new ArrayList<>();

        for(int i = 0; i < money.getLottoCount(); i++) {
            lotties.add(new Lotto(randomNumGenerator.generateNumber()));
        }
        return new Lotties(lotties);
    }

}
