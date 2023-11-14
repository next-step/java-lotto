package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

        private static final int LOTTO_TICKET_PRICE = 1_000;
        private final double purchaseAmount;
        private Tickets tickets;
        private int purchaseQuantity;

        public Lotto(long purchaseAmount) {
                this.purchaseAmount = purchaseAmount;
                validatePurchaseAmount();
                this.purchaseQuantity = (int) (this.purchaseAmount / LOTTO_TICKET_PRICE);
                this.tickets = new Tickets(generateTickets());
        }

        public Tickets tickets() {
                return tickets;
        }

        public int purchaseQuantity() {
                return purchaseQuantity;
        }

        private void validatePurchaseAmount() {
                if (purchaseAmount < LOTTO_TICKET_PRICE) {
                        throw new IllegalArgumentException("1000원 이상 입력하셔야합니다. (로또 장당 1000원)");
                }
        }

        private List<Ticket> generateTickets() {
                List<Ticket> generatedTicket = new ArrayList<>();
                for (int i = 0; i < purchaseQuantity; i++) {
                        generatedTicket.add(new Ticket());
                }
                return generatedTicket;
        }
}
