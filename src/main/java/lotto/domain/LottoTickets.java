package lotto.domain;

import lotto.domain.enums.LottoRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoTickets {

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

    public void findWinningStatistics(List<Integer> numbers, int bonusNumber) {

        Map<LottoRank, Integer> ranks = new HashMap<>();

        tickets.forEach(ticket -> {
            LottoRank rank = ticket.getHitCount(numbers, bonusNumber);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        });

        StringBuilder sb = new StringBuilder();

        Arrays.stream(LottoRank.values())
                        .forEach(rank -> {
                            String result = createResult(ranks, rank);
                            sb.append(result).append("\n");
                        });

        System.out.println(sb.toString());
    }

    private String createResult(Map<LottoRank, Integer> ranks, LottoRank rank) {
        Integer integer = ranks.get(rank);
        int count = 0;
        if (integer != null) {
            count = integer;
        }
        return String.format("%s- %d개", rank, count);
    }
}
