package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomTicketMachine implements TicketMachine {
    private static final Integer RANGE_MIN = 1;
    private static final Integer RANGE_MAX = 45;
    private final List<LottoNumber> lottoNumbers;

    public RandomTicketMachine() {
        this.lottoNumbers = IntStream.rangeClosed(RANGE_MIN, RANGE_MAX)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toList());
    }

    @Override
    public List<LottoTicket> issue(int ticketCount) {
        return Stream.generate(() -> {
            shuffle();
            return new LottoTicket(new HashSet<>(this.lottoNumbers.subList(0, 6)));
        })
              .limit(ticketCount)
              .collect(Collectors.toList());
    }

    private void shuffle() {
        Collections.shuffle(this.lottoNumbers);
    }
}
