package lotto.Model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<Ticket> tickets = new ArrayList<>();

    public Game(int countOfTicket) {
        for (int i = 0; i < countOfTicket; i++) {
            addTicket(randomTicket());
        }
    }

    public Game(int countOfTicket, List<Ticket> manualTickets) {
        for (Ticket manualTicket : manualTickets) {
            addTicket(manualTicket);
        }

        for (int i = 0; i < countOfTicket - manualTickets.size(); i++) {
            addTicket(randomTicket());
        }
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    private Ticket randomTicket() {
        TicketNumber ticketNumber = new TicketNumber();
        return new Ticket(ticketNumber);
    }

    public List<Ticket> allTickets() {
        return tickets;
    }

    public GameResult calculateResult(List<Integer> winnerNumber, int bonusNumber) {
        GameResult result = new GameResult();

        for (Ticket ticket : tickets) {
            int numberOfMatchedNumber = ticket.countMatches(winnerNumber);
            boolean isBonus = ticket.contain(bonusNumber);
            result.addCount(numberOfMatchedNumber, isBonus);
        }

        return result;
    }
}
