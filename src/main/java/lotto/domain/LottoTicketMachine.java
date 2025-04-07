package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LottoTicketMachine {

    private static final Random random = new Random();

    public static LottoTicket[] purchase(PurchasePrice purchasePrice) {
        int ticketCount = purchasePrice.calculateTicketCount(LottoTicket.PRICE_PER_TICKET);
        if (ticketCount == 0) {
            throw new IllegalArgumentException("구입 금액이 티켓 가격보다 작습니다.");
        }

        return generateTickets(ticketCount);
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
