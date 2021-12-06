package step2.service;

import step2.domain.LottoTicket;
import step2.domain.LottoTickets;
import step2.domain.Ticket;
import step2.domain.WinningNumber;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {
    private static final List<Integer> numbers = new ArrayList<>();
    private static final int LOTTO_SIZE = 6;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    static {
        for(int i = START_NUMBER; i <= END_NUMBER; ++i) {
            numbers.add(i);
        }
    }

    public LottoTickets generateLotto(Ticket ticket) {
        Ticket currentTicket = ticket;

        List<LottoTicket> lottoTickets = new ArrayList<>();

        while(currentTicket.having()) {
            lottoTickets.add(new LottoTicket(shuffleNumbers()));

            currentTicket = currentTicket.deductedTicket();
        }

        return new LottoTickets(lottoTickets);
    }

    private Set<WinningNumber> shuffleNumbers() {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(LOTTO_SIZE)
                .sorted(Integer::compareTo)
                .map(number -> new WinningNumber(number))
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }
}
