package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Game {
    private static final int WINNER_MATCH_COUNT_MIN = 3;
    private static final int WINNER_MATCH_COUNT_MAX = 6;
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

    public HashMap<Integer, Integer> calculateResult(List<Integer> winnerNumber) {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = WINNER_MATCH_COUNT_MIN; i <= WINNER_MATCH_COUNT_MAX; i++) {
            result.put(i, 0);
        }

        for (Ticket ticket : tickets) {
            int count = countMatches(ticket, winnerNumber);
            result.put(count, result.getOrDefault(count, 0) + 1);
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

    private int addIfMatch(List<Integer> numbers, int number){
        if(numbers.contains(number)){
            return 1;
        }
        return 0;
    }

}
