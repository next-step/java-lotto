package me.devyonghee.lotto.view.dto;

import me.devyonghee.lotto.model.LottoNumber;
import me.devyonghee.lotto.model.LottoTicket;
import me.devyonghee.lotto.model.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;

public final class LottoTicketsResponse {

    private final List<List<Integer>> tickets;

    private LottoTicketsResponse(List<List<Integer>> tickets) {
        this.tickets = tickets;
    }

    public static LottoTicketsResponse from(LottoTickets tickets) {
        return new LottoTicketsResponse(tickets.list()
                .stream()
                .map(LottoTicketsResponse::from)
                .collect(Collectors.toList()));
    }

    private static List<Integer> from(LottoTicket ticket) {
        return ticket.numbers()
                .collection()
                .stream()
                .map(LottoNumber::number)
                .sorted()
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getTickets() {
        return tickets;
    }
}
