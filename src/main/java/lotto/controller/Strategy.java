package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoNo;

class Strategy {
    private static final Shuffler shuffler = new Shuffler(LottoNo.MIN, LottoNo.MAX);

    private Strategy() {}

    static Lotto random() {
        return new Lotto(
                shuffler.getIntegers(Lotto.SIZE)
        );
    }
}
