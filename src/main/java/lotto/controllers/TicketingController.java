package lotto.controllers;

import java.util.Collections;

import lotto.AutomaticTicketing;
import lotto.ManualTicketsBuilder;
import lotto.domains.Purchase;
import lotto.strategy.ManualNumbers;
import lotto.strategy.RandomLottoNumbers;
import lotto.domains.Tickets;
import lotto.enums.Message;
import lotto.views.Display;

public final class TicketingController {

    private TicketingController() {
    }

    public static Tickets run(Purchase purchase) {
        Tickets manualTickets = buyManualTickets(purchase);
        Tickets automatedTickets = buyAutomatedTickets(purchase);
        Tickets allTickets = allTickets(manualTickets, automatedTickets);

        Display.show(Message.AUTOMATIC_TICKETING, manualTickets, automatedTickets);
        Display.show(allTickets);

        return allTickets;
    }

    private static Tickets buyManualTickets(Purchase purchase) {
        ManualTicketsBuilder manualTicketsBuilder = new ManualTicketsBuilder(purchase);
        manualTicketsBuilder.newTickets(new ManualNumbers());
        return manualTicketsBuilder.build();
    }

    private static Tickets buyAutomatedTickets(Purchase purchase) {
        AutomaticTicketing automaticTicketing = new AutomaticTicketing(new RandomLottoNumbers());
        return automaticTicketing.newTickets(purchase);
    }

    private static Tickets allTickets(Tickets manualTickets, Tickets automatedTickets) {
        Tickets allTickets = new Tickets(Collections.emptyList());
        allTickets.append(manualTickets);
        allTickets.append(automatedTickets);
        return allTickets;
    }

}
