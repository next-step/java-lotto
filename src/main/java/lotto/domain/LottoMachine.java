package lotto.domain;

import lotto.domain.vo.LottoMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static LottoBill purchaseLottoTicket(LottoMoney lottoMoney) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < lottoMoney.getNumberOfTicket(); i++) {
            lottoTickets.add(LottoTicket.ofAuto());
        }

        return new LottoBill(lottoTickets);
    }
}
