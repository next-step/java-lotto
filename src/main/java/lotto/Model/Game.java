package lotto.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    private static final int WINNER_MATCH_COUNT_MIN = 3;
    private static final int WINNER_MATCH_COUNT_MAX = 6;
    private static final int BONUS_CANDIDATE_COUNT = 5;
    private static final int BONUS_CATEGORY = 15;

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

    public HashMap<Integer, Integer> calculateResult(List<Integer> winnerNumber, int bonusNumber) {
        HashMap<Integer, Integer> result = resultFormat();

        for (Ticket ticket : tickets) {
            int count = countMatches(ticket, winnerNumber, bonusNumber);
            result.put(count, result.getOrDefault(count, 0) + 1);
        }

        for (int i = 0; i < WINNER_MATCH_COUNT_MIN; i++) {
            result.remove(i);
        }

        return result;
    }

    private HashMap<Integer, Integer> resultFormat() {
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = WINNER_MATCH_COUNT_MIN; i <= WINNER_MATCH_COUNT_MAX; i++) {
            result.put(i, 0);
        }
        result.put(BONUS_CATEGORY, 0);

        return result;
    }

    private int countMatches(Ticket ticket, List<Integer> winnerNumber, int bonusNumber) {
        int count = 0;
        TicketNumber ticketNumber = ticket.numbers();
        for (Integer number : ticketNumber.numbers()) {
            count += addIfMatch(winnerNumber, number);
            count = ifMatchBonus(ticket, bonusNumber, count);
        }
        return count;
    }

    private int addIfMatch(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private int ifMatchBonus(Ticket ticket, int bonusNumber, int count) {
        if (BONUS_CANDIDATE_COUNT != count) {
            return count;
        }

        TicketNumber ticketNumber = ticket.numbers();
        if (ticketNumber.contain(bonusNumber)) {
            return BONUS_CATEGORY;
        }

        return count;
    }

}
