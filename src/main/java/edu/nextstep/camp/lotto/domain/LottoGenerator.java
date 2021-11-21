package edu.nextstep.camp.lotto.domain;

import java.util.Collections;

@FunctionalInterface
public interface LottoGenerator {
    default Lottos generate(int amount) {
        return Lottos.of(Collections.nCopies(amount, generate()));
    }

    Lotto generate();
}
