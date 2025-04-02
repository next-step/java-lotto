package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoTicketMachine {

    private static final int LOTTO_PRICE = 1000;

    public static LottoTicket[] purchase(int amount) {
        validateAmount(amount);
        return generateTickets(calculateTicketCount(amount));
    }

    private static void validateAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("Amount must be a multiple of 1000");
        }
    }

    private static int calculateTicketCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private static LottoTicket[] generateTickets(int ticketCount) {
        LottoTicket[] tickets = new LottoTicket[ticketCount];
        for (int i = 0; i < ticketCount; i++) {
            tickets[i] = new LottoTicket(generateRandomNumbers());
        }
        return tickets;
    }

    private static List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(new Random().nextInt(45) + 1);
        }
        return numbers;
    }

}
