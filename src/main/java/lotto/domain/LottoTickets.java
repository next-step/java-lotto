package lotto.domain;

import lotto.domain.enums.LottoRank;
import lotto.ui.LottoResult;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    public int size() {
        return tickets.size();
    }

    public LottoResult createLottoResult(List<Integer> numbers, int bonusNumber) {

        Map<LottoRank, Integer> ranks = new HashMap<>();

        tickets.forEach(ticket -> {
            LottoRank rank = ticket.getHitCount(numbers, bonusNumber);
            checkNull(ranks, rank);
        });

        return new LottoResult(ranks, size() * LOTTO_PRICE);
    }

    private void checkNull(Map<LottoRank, Integer> ranks, LottoRank rank) {
        if (rank != null) {
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
    }
}
