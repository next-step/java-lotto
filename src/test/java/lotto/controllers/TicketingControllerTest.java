package lotto.controllers;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.Lotto;
import lotto.Model;
import lotto.domains.Purchase;
import lotto.domains.Ticket;
import lotto.domains.Tickets;

public class TicketingControllerTest {

    private static final int amount = 12;
    private Purchase purchase = new Purchase("12345");

    private Model model = new Model();
    private Lotto lotto = new Lotto(model);
    private Tickets tickets = new Tickets(Collections.singletonList(new Ticket("1,2,3,4,5,6")));

    private TicketingController ticketingController;

    @BeforeEach
    void setUp() {
        lotto.storage().savePurchase(purchase);
        ticketingController = new TicketingController(lotto);
    }

    @DisplayName("티켓 수 불러오기")
    @Test
    void loadPurchase() {
        assertThat(ticketingController.loadPurchase().ticketsAmount()).isEqualTo(amount);
    }

    @DisplayName("자동 티켓 구매")
    @Test
    void buyAutomatedTickets() {
        assertThat(ticketingController.buyAutomatedTickets(amount).size()).isEqualTo(amount);
    }

    @DisplayName("모든 티켓 저장")
    @Test
    void saveTickets() {
        ticketingController.saveTickets(tickets);
        assertThat(lotto.storage().loadTickets().size()).isEqualTo(tickets.size());
    }

}
