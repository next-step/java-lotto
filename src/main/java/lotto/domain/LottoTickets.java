package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoHitInfo;
import lotto.ui.LottoResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

    private static final int LOTTO_PRICE = 1000;

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets of(int count) {
        List<LottoTicket> tickets = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            tickets.add(LottoTicket.create());
        }

        return new LottoTickets(tickets);
    }

    public static LottoTickets of(List<LottoTicket> tickets) {
        return new LottoTickets(tickets);
    }

    public void addLottoTickets(LottoTickets lottoTickets) {
        lottoTickets.tickets.forEach(this::addTicket);
    }

    private void addTicket(LottoTicket ticket) {
        this.tickets.add(ticket);
    }

    public int size() {
        return tickets.size();
    }

    public LottoResult createLottoResult(final LottoHitInfo hitInfo) {

        Map<LottoRank, Integer> ranks = new HashMap<>();

        tickets.forEach(ticket -> {
            LottoRank rank = ticket.getHitCount(hitInfo);
            checkNull(ranks, rank);
        });

        return new LottoResult(ranks, size() * LOTTO_PRICE);
    }

    private void checkNull(Map<LottoRank, Integer> ranks, LottoRank rank) {
        if (rank != null) {
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
    }

    public static LottoTickets createManualLottoTickets(final List<List<Integer>> numbers) {
        List<LottoTicket> manualLottoTickets = new ArrayList<LottoTicket>();

        for (List<Integer> number : numbers) {
            LottoTicket manualLottoTicket = LottoTicket.of(number);
            manualLottoTickets.add(manualLottoTicket);
        }
        return LottoTickets.of(manualLottoTickets);
    }

    public void printLottoTickets() {
        this.tickets.forEach(LottoTicket::printLottoNumbers);
    }
}
