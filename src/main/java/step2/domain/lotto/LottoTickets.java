package step2.domain.lotto;

import step2.Constant;
import step2.strategy.NumberMakeStrategy;
import step2.type.WinningType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LottoTickets {
    private static final int NOT_EXISTS_INDEX = -1;
    private static final int INIT_WINNING_COUNT = 0;
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

    public double getRevenueRate(WinningNumber winningNumber) {
        Map<WinningType, Integer> winningStatistics = getWinningStatistics(winningNumber);
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

    public Map<WinningType, Integer> getWinningStatistics(WinningNumber winningNumber) {
        Map<WinningType, Integer> winningStatistics = getInitWinningStatisticsMap();
        tickets.forEach(ticket -> {
            WinningType winningType = ticket.compareWinningNumber(winningNumber);
            appendWinningCount(winningStatistics, winningType);
        });
        return winningStatistics;
    }

    private Map<WinningType, Integer> getInitWinningStatisticsMap() {
        return new HashMap<WinningType, Integer>() {{
            put(WinningType.RANK_ONE, INIT_WINNING_COUNT);
            put(WinningType.RANK_TWO, INIT_WINNING_COUNT);
            put(WinningType.RANK_THREE, INIT_WINNING_COUNT);
            put(WinningType.RANK_FOUR, INIT_WINNING_COUNT);
        }};
    }

    private void appendWinningCount(Map<WinningType, Integer> map, WinningType type) {
        if (!WinningType.RANK_ETC.equals(type)) {
            Integer findInteger = map.getOrDefault(type, NOT_EXISTS_INDEX);
            map.put(type, increaseWinningCount(findInteger));
        }
    }

    private int increaseWinningCount(Integer findInteger) {
        if (findInteger <= 0) {
            findInteger = INIT_WINNING_COUNT;
        }
        return ++findInteger;
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
