package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Tickets {

    private List<Ticket> tickets = new ArrayList<>();

    public Tickets(int purchaseQuantity, NumberGenerationStrategy generationStrategy) {

        for (int i = 0; i < purchaseQuantity; i++) {
            tickets.add(new Ticket(generationStrategy));
        }
    }

    public int size() {
        return tickets.size();
    }
}
