package lotto.domain;

import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketGenerator;
import lotto.domain.ticket.LottoTickets;
import lotto.vo.Money;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoGameProperty.LOTTO_TICKET_PRICE;

public class LottoStore {
    private final LottoTicketGenerator lottoTicketGenerator;

    public LottoStore(final LottoTicketGenerator lottoTicketGenerator) {
        this.lottoTicketGenerator = lottoTicketGenerator;
    }

    public LottoTickets buy(Money budget, LottoTickets manualLottoTickets) {
        Money currentMoney = budget.spend(LOTTO_TICKET_PRICE.multiply(manualLottoTickets.count()));
        LottoTickets autoLottoTickets = buy(currentMoney);

        return manualLottoTickets.combine(autoLottoTickets);
    }

    private LottoTickets buy(final Money budget) {
        Money currentMoney = budget;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        while (currentMoney.isEnoughToBuy(LOTTO_TICKET_PRICE)) {
            lottoTickets.add(lottoTicketGenerator.createAutoLottoTicket());
            currentMoney = currentMoney.spend(LOTTO_TICKET_PRICE);
        }

        return new LottoTickets(lottoTickets);
    }
}
