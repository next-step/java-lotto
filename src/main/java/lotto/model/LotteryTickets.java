package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LotteryTickets {

    private static final int LOTTERY_PRICE = 1000;

    private final List<LotteryTicket> tickets;

    private LotteryTickets(List<LotteryTicket> tickets) {
        this.tickets = tickets;
    }

    public static LotteryTickets of(int money, LotteryNumberGenerator lotteryNumberGenerator) {
        List<LotteryTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTERY_PRICE; i++) {
            tickets.add(LotteryTicket.of(lotteryNumberGenerator));
        }
        return new LotteryTickets(tickets);
    }

    public Map<Win, Integer> getWinTotal(WinNumbers winNumbers) {
        Map<Integer, Integer> groupedCount = getWinCountGroupMap(winNumbers);
        return Win.convertToWinMap(groupedCount);
    }

    private Map<Integer, Integer> getWinCountGroupMap(WinNumbers winNumbers) {
        return tickets.stream()
                .collect(Collectors.groupingBy(
                        ticket -> ticket.compare(winNumbers), Collectors.summingInt(ticket -> 1))
                );
    }

    public int size() {
       return this.tickets.size();
    }

    public List<LotteryTicket> getTickets() {
        return List.copyOf(tickets);
    }
}
