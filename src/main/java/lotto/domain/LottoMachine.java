package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static List<LottoTicket> pay(long money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getTicketCount(money); i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        return new LottoTicket(LottoNumberPool.generateLottoNumbers());
    }

    private static long getTicketCount(long money) {
        return money / LottoTicket.PRICE;
    }
}
