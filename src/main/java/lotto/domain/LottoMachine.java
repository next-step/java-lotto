package lotto.domain;

import lotto.common.NumberGenerator;

import java.util.*;

public class LottoMachine {
    public Lottos generateLottos(Money money, NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < money.getLottoCount(); i++) {
            lottos.add(new Lotto(numberGenerator));
        }

        return new Lottos(lottos);
    }

}
