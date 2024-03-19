package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final static List<Integer> LottoNumbers = IntStream.range(0, 45)
            .mapToObj(i -> i + 1)
            .collect(Collectors.toList());

    private final List<Integer> ticket;

    public LottoTicket() {
        Collections.shuffle(LottoNumbers);
        this.ticket = LottoNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return ticket.toString();
    }
}
