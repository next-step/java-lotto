package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.vo.LottoMoney;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private LottoMachine() {
    }

    public static LottoBill purchaseLottoTicket(int numberOfAutoTicket) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfAutoTicket; i++) {
            lottoTickets.add(LottoTicket.ofAuto());
        }

        return new LottoBill(lottoTickets);
    }
}
