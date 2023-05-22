package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.Ticket.*;

public class LottoGenerator {

    public static LottoTickets generateAutoTickets(long numberOfTicket) {
        List<Ticket> tickets = new ArrayList<>();
        long numberOfTickets = numberOfTicket;

        for (int i = 0; i < numberOfTickets; i++) {
            List<Integer> candidateNumbers = makeCandidateNumbers();
            Collections.shuffle(candidateNumbers);
            Ticket newTicket = Ticket.from(candidateNumbers.subList(0, SIZE_LOTTO_NUMBER));
            tickets.add(newTicket);
        }

        return LottoTickets.from(tickets);
    }

    public static LottoTickets generateManualTickets(List<Ticket> tickets) {
        return LottoTickets.from(tickets);
    }

    private static List<Integer> makeCandidateNumbers() {
        return IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .boxed()
                .collect(Collectors.toList());
    }
}
