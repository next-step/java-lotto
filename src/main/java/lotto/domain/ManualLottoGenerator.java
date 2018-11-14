package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

    private List<String> manualTickets;

    public ManualLottoGenerator(List<String> manualTickets) {
        this.manualTickets = manualTickets;
    }

    @Override
    public List<Ticket> generate() {
        List<Ticket> tickets = new ArrayList<>();

        for (String s : manualTickets) {
            tickets.add(convertToTicket(s.split(", ")));
        }

        return tickets;
    }

    private Ticket convertToTicket(String[] str) {
        List<Integer> list = new ArrayList<>();

        for(String s : str) {
            list.add(Integer.parseInt(s));
        }

        return new Ticket(list);
    }
}
