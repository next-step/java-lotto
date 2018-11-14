package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Ticket> tickets = new ArrayList<>();

    public Lotto(Amount amount, LottosGenerator lottosGenerator) {
        tickets = lottosGenerator.generate(amount);
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Ticket> addTickets(List<Ticket> tickets) {
        return tickets;
    }
}
