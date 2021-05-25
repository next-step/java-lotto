package lotto.domains;

import java.util.List;

import lotto.enums.ErrorMessage;
import lotto.enums.Prize;

public class Tickets {

    private List<Ticket> tickets;

    public Tickets(List<Ticket> tickets) {
        if (tickets == null || tickets.isEmpty()) {
            throw new NullPointerException(ErrorMessage.NULL_TICKETS.toString());
        }

        this.tickets = tickets;
    }

    public int size() {
        return this.tickets.size();
    }

    public Scores scores(WinningNumbers winningNumbers) {
        Scores scores = new Scores();

        for (Ticket ticket : this.tickets) {
            Prize key = winningNumbers.classifyPrize(ticket);
            scores.increase(key);
        }

        return scores;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        for (Ticket ticket : this.tickets) {
            message.append(ticket.toString()).append(System.lineSeparator());
        }
        return message.toString();
    }
}
