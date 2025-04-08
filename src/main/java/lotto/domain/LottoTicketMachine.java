package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int COUNT = 6;
    private static final List<Integer> TOTAL_NUMBERS = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());

    public static List<LottoTicket> purchase(LottoOrder lottoOrder) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < lottoOrder.getTotalCount(); i++) {
            tickets.add(generateTicket());
        }
        return tickets;
    }

    private static LottoTicket generateTicket() {
        List<Integer> numbers = new ArrayList<>(TOTAL_NUMBERS);
        Collections.shuffle(numbers);
        return new LottoTicket(numbers.subList(0, COUNT));
    }

}
