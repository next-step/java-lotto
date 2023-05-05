package lotto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private final List<Ticket> tickets = new ArrayList<>();

    public Game(int countOfTicket) {
        for (int i = 0; i < countOfTicket; i++) {
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
            int numberOfMatchedNumber = countMatches(ticket, winnerNumber);
            boolean isBonus = ifMatchBonus(ticket, bonusNumber);
            result.addCount(numberOfMatchedNumber, isBonus);
        }

        return result;
    }



    private int countMatches(Ticket ticket, List<Integer> winnerNumber) {
        int count = 0;
        TicketNumber ticketNumber = ticket.numbers();
        for (Integer number : ticketNumber.numbers()) {
            count += addIfMatch(winnerNumber, number);
        }
        return count;
    }

    private int addIfMatch(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private boolean ifMatchBonus(Ticket ticket, int bonusNumber) {
        TicketNumber ticketNumber = ticket.numbers();
        return ticketNumber.contain(bonusNumber);
    }

}
