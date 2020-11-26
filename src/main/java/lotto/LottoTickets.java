package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> ticketList = new ArrayList<>();

    public LottoTickets() {
        this(1);
    }

    public LottoTickets(int purchaseNumber) {
        for (int i = 0; i < purchaseNumber; i++) {
            ticketList.add(new LottoTicket().createAuto());
        }
    }

    public LottoTicket getLottoTicket(int index) {
        return ticketList.get(index);
    }

    public int size() {
        return ticketList.size();
    }
}
