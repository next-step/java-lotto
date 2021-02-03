package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    private final List<Integer> lottoNumbers;

    public Ticket(List<Integer> tickets) {
        this.lottoNumbers = tickets;
    }

    public Stream<Integer> lottoNumberStream() {
        return lottoNumbers.stream();
    }

    public long matchNumber(Ticket newTicket) {
        return newTicket.lottoNumberStream()
            .filter(lottoNumbers::contains)
            .count();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
