package lotto.domain.lotto.ticket;


import lotto.domain.Prize;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {
    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public LottoTickets(LottoTicket... ticket) {
        this.tickets = Arrays.stream(ticket).collect(Collectors.toList());
    }

    public void add(LottoTicket ticket) {
        tickets.add(ticket);
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public Map<Prize, Integer> getHitLottoNumbers(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        Map<Prize, Integer> map = initialMap();
        this.tickets.forEach(ticket -> {
            int hitNumber = ticket.hitNumber(winningLottoTicket.getNumbers());
            boolean isBonus = ticket.isBonus(bonusNumber);
            Prize prize = Prize.valueOf(hitNumber, isBonus);
            map.put(prize, map.getOrDefault(prize, 0) + 1);
        });

        return map;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(tickets, that.tickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tickets);
    }

    @Override
    public String toString() {
        return "LottoTickets{" +
                "tickets=" + tickets +
                '}';
    }

    private Map<Prize, Integer> initialMap() {
        Map<Prize, Integer> map = new HashMap<>();
        for (Prize prize : Prize.values()) {
            map.put(prize, 0);
        }
        return map;
    }
}
