package lotto.Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Game {
    private final List<Ticket> tickets = new ArrayList<>();

    public Game(int countOfTicket) {
        for (int i = 0; i < countOfTicket; i++) {
            add(randomTicket());
        }
    }

    private void add(Ticket ticket) {
        tickets.add(ticket);
    }

    private Ticket randomTicket() {
        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= 45; i++) numList.add(i);
        Collections.shuffle(numList);

        List<Integer> ticketNumber = numList.subList(0, 6);
        Collections.sort(ticketNumber);

        return new Ticket(ticketNumber);
    }

    public List<Ticket> allTickets() {
        return tickets;
    }

    public HashMap<Integer, Integer> calculateResult(List<Integer> winnerNumber) {
        HashMap<Integer, Integer> result = new HashMap<>() {{
            for (int i = 3; i <= 6; i++) put(i, 0);

        }};

        for (Ticket ticket : tickets) {
            int count = countMatches(ticket, winnerNumber);
            result.put(count, result.getOrDefault(count, 0) + 1);
        }

        return result;
    }

    private int countMatches(Ticket ticket, List<Integer> winnerNumber) {
        int count = 0;
        for (Integer number : ticket.numbers()) {
            if (winnerNumber.contains(number)) {
                count++;
            }
        }
        return count;
    }

}
