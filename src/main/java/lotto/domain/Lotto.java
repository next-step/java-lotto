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
    private final static int LOTTO_TICKET_PRICE = 1000;
    private final static int LOTTO_TICKET_BUY_MAX_PRICE = 100000;

    private final int payment;
    private List<LottoTicket> lottoTickets = null;

    public Lotto(final int payment) {
        if (payment < LOTTO_TICKET_PRICE || payment > LOTTO_TICKET_BUY_MAX_PRICE) {
            throw new IllegalArgumentException("입력하신 금액이 올바르지 않습니다. (최소 금액:" + LOTTO_TICKET_PRICE + "원, 최대 금액:" + LOTTO_TICKET_BUY_MAX_PRICE + ")");
        }
        this.payment = payment;
        this.lottoTickets = new ArrayList<>();
    }

    public void issue() {
        lottoTickets = IntStream.range(0, payment / LOTTO_TICKET_PRICE)
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

    public int payment() {
        return payment;
    }

    public List<LottoTicket> lottoTickets() {
        return lottoTickets;
    }
}
