package edu.nextstep.camp.lotto.domain;

import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
public interface LottoGenerator {
    default Lottos generate(int amount) {
        List<Lotto> lottoList = new ArrayList<>(amount);
        while (lottoList.size() < amount) {
            lottoList.add(generate());
        }

        return Lottos.of(lottoList);
    }

    Lotto generate();
}
