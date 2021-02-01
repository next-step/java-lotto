package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Lotto {

    private List<Ticket> tickets = new ArrayList<>();
    private WinningNumber winningNumber;

    public Lotto(WinningNumber winningNumber, List<Ticket> tickets){
        this.winningNumber = winningNumber;
        this.tickets = tickets;
    }

    public Lotto() {}

    public Map<Revenue, Integer> statisticsTicket() {
        Map<Revenue, Integer> revenueMap = new HashMap<>();
        for (Ticket ticket : tickets) {
            Revenue matchingLotto = Revenue.checkTheNumberOfMatchingLotto(ticket, winningNumber);
            revenueMap.computeIfPresent(matchingLotto,((revenue, count) -> ++count));
            revenueMap.putIfAbsent(matchingLotto, 1);
        }
        return revenueMap;
    }

    public int calculateTotalPrize(Map<Revenue, Integer> revenueMap) {
        int totalRevenue = 0;
        for (Entry<Revenue, Integer> entry : revenueMap.entrySet()) {
            Revenue revenue = entry.getKey();
            Integer integer = entry.getValue();
            totalRevenue += revenue.totalRevenue(integer);
        }
        return totalRevenue;
    }

    public boolean earnedMoney(Double yield) {
        return yield >= 1;
    }
}
