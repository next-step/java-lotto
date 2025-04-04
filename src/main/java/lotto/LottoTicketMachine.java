package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoTicketMachine {

    private static final Random random = new Random();

    public static LottoTicket[] purchase(int amount) {
        validateAmount(amount);
        return generateTickets(calculateTicketCount(amount));
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount % LottoTicket.PRICE_PER_TICKET != 0) {
            throw new IllegalArgumentException("Amount must be a multiple of 1000");
        }
    }

    private static int calculateTicketCount(int amount) {
        return amount / LottoTicket.PRICE_PER_TICKET;
    }

    private static LottoTicket[] generateTickets(int ticketCount) {
        LottoTicket[] tickets = new LottoTicket[ticketCount];
        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = new LottoTicket(generateRandomNumbers());
        }
        return tickets;
    }

    private static List<Integer> generateRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 6) {
            numbers.add(random.nextInt(45) + 1);
        }

        return new ArrayList<>(numbers);
    }

}
