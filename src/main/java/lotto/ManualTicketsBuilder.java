package lotto;

import java.util.ArrayList;
import java.util.List;

import lotto.domains.Purchase;
import lotto.domains.Ticket;
import lotto.domains.Tickets;
import lotto.enums.ErrorMessage;
import lotto.enums.Message;
import lotto.exceptions.NumberOutOfBoundsException;
import lotto.exceptions.TicketsOutOfBoundsException;
import lotto.strategy.LottoNumbers;
import lotto.tool.Converter;
import lotto.views.Display;

public class ManualTicketsBuilder {

    private static final int MIN_VALUE = 0;

    private List<Ticket> manualTickets = new ArrayList<>();
    private int manualAmount;

    public ManualTicketsBuilder(Purchase purchase, String text) {
        int manualAmount = Converter.toInteger(text);
        int totalAmount = purchase.ticketsAmount();

        if (manualAmount < MIN_VALUE || totalAmount < manualAmount) {
            throw new NumberOutOfBoundsException(ErrorMessage.MANUAL_AMOUNT_OUT_OF_BOUNDS.toString());
        }

        this.manualAmount = manualAmount;
    }

    public ManualTicketsBuilder newTickets(LottoNumbers lottoNumbers) {
        if (this.manualAmount == 0) {
            Display.show(Message.SKIP_MANUAL_TICKETING);
            return this;
        }

        Display.show(Message.MANUAL_TICKETING);
        while (this.manualAmount != this.manualTickets.size()) {
            newTicket(lottoNumbers);
        }

        return this;
    }

    private void newTicket(LottoNumbers lottoNumbers) {
        try {
            Ticket ticket = new Ticket(lottoNumbers.choose());
            this.manualTickets.add(ticket);
        } catch (Exception e) {
            Display.error(e.getMessage());
        }
    }

    public Tickets build() {
        if (this.manualAmount != this.manualTickets.size()) {
            throw new TicketsOutOfBoundsException(ErrorMessage.MANUAL_TICKETS_OUT_OF_BOUNDS.toString());
        }

        return new Tickets(this.manualTickets);
    }

}
