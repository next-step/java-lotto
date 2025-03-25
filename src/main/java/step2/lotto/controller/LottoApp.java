package step2.lotto.controller;

import java.util.ArrayList;
import java.util.List;
import step2.lotto.model.LottoMachine;
import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;

public class LottoApp {

    private static final int LOTTO_PRICE = 1000;
    private static final LottoMachine lottoMachine = new LottoMachine();

    public LottoTicketList buyLottoTickets(Money purchaseAmount) {
        int ticketCount = purchaseAmount.value() / LOTTO_PRICE;
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(lottoMachine.issueLottoTicket());
        }
        return new LottoTicketList(lottoTickets);
    }

}
