package lotto.domain;

import lotto.common.NumberGenerator;

import java.util.*;

public class LottoMachine {
    public Lottos generateLottos(int autoCount, NumberGenerator numberGenerator) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < autoCount; i++) {
            lottos.add(Lotto.from(numberGenerator));
        }

        return new Lottos(lottos);
    }

}
