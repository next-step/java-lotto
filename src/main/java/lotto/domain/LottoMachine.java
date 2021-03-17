package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int buyAmount) {
        this.lottoTickets = createLottoTickets(buyAmount);
    }

    private List<LottoTicket> createLottoTickets(int buyAmount) {
        int lottoQuantity = amountToQuantity(buyAmount);

        List<LottoTicket> tickets = new ArrayList<>();
        for(int i = 0; i < lottoQuantity; i++) {
            tickets.add(new LottoTicket());
        }

        return tickets;
    }

    private int amountToQuantity(int amount) {
        return amount / 1000;
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
