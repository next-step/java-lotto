package lotto.controller;

import lotto.domain.Dollars;
import lotto.domain.LottoTicket;

import java.util.Collections;

public class LottoMachine {

    private LottoMachine() {
    }

    public static LottoTicket publish(int won) {
        return LottoTicket.publish(new Dollars(won), Collections::shuffle);
    }
}
