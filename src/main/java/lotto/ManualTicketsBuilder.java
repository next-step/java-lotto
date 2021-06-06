package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domains.Purchase;
import lotto.domains.Ticket;
import lotto.domains.Tickets;
import lotto.enums.ErrorMessage;
import lotto.enums.Message;
import lotto.exceptions.TicketsOutOfBoundsException;
import lotto.strategy.LottoNumbers;
import lotto.views.Display;

public class ManualTicketsBuilder {

    private List<Ticket> tickets = new ArrayList<>();
    private Tickets manualTickets = new Tickets(tickets);
    private Purchase purchase;

    public ManualTicketsBuilder(Purchase purchase) {
        this.purchase = purchase;
    }

    public ManualTicketsBuilder newTickets(LottoNumbers lottoNumbers) {
        if (purchase.skipManualTickets()) {
            Display.show(Message.SKIP_MANUAL_TICKETING);
            return this;
        }

        Display.show(Message.MANUAL_TICKETING);
        while (purchase.isNotSameAsManualAmount(manualTickets)) {
            newTicket(lottoNumbers);
        }

        return this;
    }

    private void newTicket(LottoNumbers lottoNumbers) {
        try {
            tickets.add(new Ticket(lottoNumbers.choose()));
            manualTickets = new Tickets(tickets);
        } catch (Exception e) {
            Display.error(e.getMessage());
        }
    }

    public Tickets build() {
        if (purchase.isNotSameAsManualAmount(manualTickets)) {
            throw new TicketsOutOfBoundsException(ErrorMessage.MANUAL_TICKETS_OUT_OF_BOUNDS.toString());
        }

        return manualTickets;
    }

}
