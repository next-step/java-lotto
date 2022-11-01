package lotto.view;

import lotto.domain.LottoTicket;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketView {

    private final List<Integer> numbers;

    public LottoTicketView(LottoTicket ticket) {
        this.numbers = ticket.getNumbers();
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
