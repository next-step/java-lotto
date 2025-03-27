package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private List<LottoTicket> tickets = new ArrayList<>();

    public LottoTickets(int purchaseQuantity, NumberGenerationStrategy generationStrategy) {

        for (int i = 0; i < purchaseQuantity; i++) {
            tickets.add(new LottoTicket(generationStrategy));
        }
    }

    public int size() {
        return tickets.size();
    }

    public List<LottoTicket> getAll() {
        return Collections.unmodifiableList(tickets);
    }
}
