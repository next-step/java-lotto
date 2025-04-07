package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    public static List<LottoTicket> purchase(LottoOrder lottoOrder) {
        int ticketCount = lottoOrder.getTicketCount();
        return generateTickets(ticketCount);
    }

    private static List<LottoTicket> generateTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    private static List<Integer> generateTotalNumbers() {
        return IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());
    }

    private static List<Integer> shuffleAndSelect(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }

    private static LottoTicket generateTicket() {
        List<Integer> numbers = generateTotalNumbers();
        List<Integer> selectedNumbers = shuffleAndSelect(numbers);
        return new LottoTicket(selectedNumbers);
    }

}
