package lotto.controller;

import lotto.domain.LottoCount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoTicket;

public class LottoMachine {

    private static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();

    private LottoMachine() {
    }

    public static LottoTicket purchaseLotto(LottoCount lottoCount) {
        return null;
    }
}
