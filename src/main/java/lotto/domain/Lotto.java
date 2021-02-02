package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Lotto {

    private final Tickets tickets;
    private final WinningInfo winningInfo;

    public Lotto(WinningInfo winningInfo, Tickets tickets) {
        this.winningInfo = winningInfo;
        this.tickets = tickets;
    }

    public Lotto() {
        tickets = new Tickets();
        winningInfo = new WinningInfo();
    }

    public Map<Revenue, Integer> statisticsTicket() {
        Map<Revenue, Integer> revenueMap = new HashMap<>();
        tickets.getTicketStream().forEach(ticket -> {
            Revenue matchingLotto = Revenue.checkTheNumberOfMatchingLotto(ticket, winningInfo);
            revenueMap.computeIfPresent(matchingLotto, ((revenue, count) -> ++count));
            revenueMap.putIfAbsent(matchingLotto, 1);
        });
        return revenueMap;
    }
}
