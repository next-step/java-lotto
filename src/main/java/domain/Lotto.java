package domain;

import utils.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final int PRICE_PER_ONE_LOTTO = 1000;

    private List<Ticket> tickets = new ArrayList<>();
    private Ticket winningNumbers;

    public int countTicket(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_ONE_LOTTO;
    }

    public List<Ticket> generateTickets(int count) {
        for(int i = 0; i < count; i++) {
            Ticket ticket = new Ticket(Utils.generateRandomNumbers());
            this.tickets.add(ticket);
        }
        return this.tickets;
    }

    public Map<Integer, Integer> playLotto(String winningNumbers) {
        this.winningNumbers = convertWinningNumbers(winningNumbers);
        return generateGameResult();
    }

    private Map<Integer, Integer> generateGameResult() {
        Map<Integer, Integer> results = new HashMap<>();

        for(int i = 0; i <= winningNumbers.getNumbers().size(); i++) {
            results.put(i, matchingCount(i));
        }

        return results;
    }

    protected int matchingCount(int matchCount) {
        return (int) this.tickets.stream()
                .filter(ticket -> ticket.getCountOfMatches(winningNumbers) == matchCount)
                .count();
    }

    public Ticket convertWinningNumbers (String s) {
        String [] numbers = s.replace(" ", "").split(",");

        List<Integer> winningNumbers = Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        return new Ticket(winningNumbers);
    }
}
