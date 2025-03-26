package step2.lotto.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import step2.lotto.model.Count;
import step2.lotto.model.LottoMachine;
import step2.lotto.model.LottoTicket;
import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;

public class LottoApp {

    private static final LottoMachine lottoMachine = new LottoMachine();

    public LottoTicketList buyLottoTickets(Money purchaseAmount) {
        Count ticketCount = new Count(purchaseAmount.value() / LottoTicket.PRICE.value());
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount.value(); i++) {
            lottoTickets.add(lottoMachine.issueLottoTicket());
        }
        return new LottoTicketList(lottoTickets);
    }

}
