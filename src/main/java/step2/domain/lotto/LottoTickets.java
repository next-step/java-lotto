package step2.domain.lotto;

import step2.Constant;
import step2.strategy.NumberMakeStrategy;
import step2.type.WinningType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final int REVENUE_ANCHOR_POINT = 1;
    private final List<LottoTicket> tickets;

    public LottoTickets(int count, NumberMakeStrategy strategy) {
        tickets = new ArrayList<>();
        IntStream.range(0, count)
                .forEach(index -> tickets.add(new LottoTicket(strategy)));
    }

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public int countTicket() {
        return tickets.size();
    }

    public double getRevenueRate(WinningNumbers winningNumbers) {
        Map<WinningType, Integer> winningStatistics = winningNumbers.getWinningStatistics(this);
        double totalAmount = getTotalAmount(winningStatistics);

        return calculateRateAndFixedTwo(totalAmount);
    }

    private double getTotalAmount(Map<WinningType, Integer> winningStatistics) {
        double totalAmount = 0;
        for (WinningType type : winningStatistics.keySet()) {
            Integer matchCount = winningStatistics.get(type);
            totalAmount += WinningType.getWinningAmount(type) * matchCount;
        }
        return totalAmount;
    }

    private double calculateRateAndFixedTwo(double totalAmount) {
        return Math.round((totalAmount / getExpenses()) * 100) / 100D;
    }

    private double getExpenses() {
        return tickets.size() * Constant.LOTTO_PRICE;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        tickets.forEach(ticket -> sb.append(ticket.toString())
                .append(System.lineSeparator()));
        return sb.toString();
    }

    public boolean isRevenue(double revenueRate) {
        return revenueRate > REVENUE_ANCHOR_POINT;
    }
}
