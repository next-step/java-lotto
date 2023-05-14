package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoConstants.*;

public class LottoGenerator {
    public static LottoTickets generateTickets(long money) {
        List<Ticket> tickets = new ArrayList<>();
        long numberOfTickets = money / LOTTO_PRICE;

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> candidateNumbers = IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                    .boxed()
                    .collect(Collectors.toList());
            Collections.shuffle(candidateNumbers);
            Ticket newTicket = Ticket.from(candidateNumbers.subList(0, SIZE_LOTTO_NUMBER));
            tickets.add(newTicket);
        }

        return LottoTickets.from(tickets);
    }
}
