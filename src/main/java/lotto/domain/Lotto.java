package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.shuffleNumbers;

public class Lotto {

    private final static int COUNT_OF_LOTTO_TICKET_NUMBER = 6;

    private List<LottoTicket> lottoTickets = null;

    public Lotto() {
        this.lottoTickets = new ArrayList<>();
    }

    public void issue(Payment payment) {
        lottoTickets = IntStream.range(0, payment.count())
                .mapToObj(i -> new LottoTicket(new TreeSet<>(shuffleNumbers().stream()
                        .limit(COUNT_OF_LOTTO_TICKET_NUMBER)
                        .collect(Collectors.toList()))))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Integer> matchingCountsByTickets(final LottoTicket winningNumber) {
        if (lottoTickets.isEmpty() || winningNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 비교할 수 없습니다.");
        }
        return lottoTickets.stream()
                .map(ticket -> compareNumber(ticket.lottoTicket(), winningNumber.lottoTicket()))
                .collect(Collectors.toList());
    }

    private int compareNumber(final Set<Integer> ticket, final Set<Integer> winningNumber) {
        return ticket.stream()
                .mapToInt(number -> winningNumber.contains(number) ? 1 : 0)
                .sum();
    }

    public List<LottoTicket> lottoTickets() {
        return lottoTickets;
    }
}
