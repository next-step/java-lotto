package lotto.model;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LotteryTickets {

    private static final int LOTTERY_PRICE = 1000;

    private final List<LotteryTicket> tickets;

    private LotteryTickets(List<LotteryTicket> tickets) {
        this.tickets = tickets;
    }

    public static LotteryTickets of(int money, LotteryNumberGenerator lotteryNumberGenerator) {
        if (money < 0) {
            throw new IllegalArgumentException("지불한 돈은 음수일 수 없습니다");
        }
        List<LotteryTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTERY_PRICE; i++) {
            tickets.add(LotteryTicket.of(lotteryNumberGenerator));
        }
        return new LotteryTickets(tickets);
    }

    public Map<Win, Integer> getTotalWin(WinNumbers winNumbers) {
        return tickets.stream()
                .map(ticket -> ticket.matchCount(winNumbers))
                .map(Win::from)
                .collect(Collectors.groupingBy(
                        Function.identity(), Collectors.summingInt(win -> 1))
                );
    }

    public int size() {
       return this.tickets.size();
    }

    public List<LotteryTicket> getTickets() {
        return List.copyOf(tickets);
    }

}
