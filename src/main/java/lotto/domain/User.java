package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class User {

    private List<LottoTicket> lottoTickets;

    public User() {
        lottoTickets = new ArrayList<>();
    }

    public void receiveTickets(final List<LottoTicket> lottoTickets) {
        if (lottoTickets == null || lottoTickets.isEmpty()) {
            throw new IllegalArgumentException("로또 티켓을 전달 받지 못하였습니다.");
        }
        this.lottoTickets = lottoTickets;
    }

    public List<Integer> matchingCountsByTickets(final LottoTicket winningNumber) {
        if (lottoTickets.isEmpty() || winningNumber == null) {
            throw new IllegalArgumentException("당첨 번호를 비교할 수 없습니다.");
        }
        return lottoTickets.stream()
                .map(ticket -> compareNumber(ticket.lottoTicket(), winningNumber.lottoTicket()))
                .collect(Collectors.toList());
    }

    public List<LottoTicket> lottoTickets() {
        if (lottoTickets == null) {
            lottoTickets = new ArrayList<>();
        }
        return lottoTickets;
    }

    private int compareNumber(final Set<Integer> ticket, final Set<Integer> winningNumber) {
        return ticket.stream()
                .mapToInt(number -> winningNumber.contains(number) ? 1 : 0)
                .sum();
    }
}
