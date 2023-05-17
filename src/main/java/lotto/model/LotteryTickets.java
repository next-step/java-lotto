package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lotto.model.LotteryEnum.LOTTERY_PRICE;

public class LotteryTickets {

    private final List<LotteryTicket> tickets;

    public LotteryTickets(List<LotteryTicket> tickets) {
        this.tickets = tickets;
    }

    public static LotteryTickets of(int money, int manualLotteryTicketCount, LotteryNumberGenerator lotteryNumberGenerator) {
        return LotteryTickets.of(calculateChange(money, manualLotteryTicketCount), lotteryNumberGenerator);
    }

    public static LotteryTickets of(int money, LotteryNumberGenerator lotteryNumberGenerator) {
        if (money < 0) {
            throw new IllegalArgumentException("지불한 돈은 음수일 수 없습니다");
        }
        List<LotteryTicket> tickets = new ArrayList<>();
        for (int i = 0; i < calculateTicketCount(money); i++) {
            tickets.add(LotteryTicket.of(lotteryNumberGenerator));
        }
        return new LotteryTickets(tickets);
    }

    private static int calculateChange(int money, int manualLotteryTicketCount) {
        int result = money - manualLotteryTicketCount * LotteryEnum.LOTTERY_PRICE.value();
        if (result < 0) {
            throw new IllegalArgumentException("지불한 돈 이상으로 구매할 수 없습니다.");
        }
        return result;
    }

    private static int calculateTicketCount(int money) {
        return money / LOTTERY_PRICE.value();
    }

    public LotteryTickets addAll(LotteryTickets tickets) {
        List<LotteryTicket> result = new ArrayList<>(this.tickets);
        result.addAll(tickets.getTickets());
        return new LotteryTickets(result);
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
