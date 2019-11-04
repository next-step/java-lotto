package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    static final int TICKET_PRICE = 1000;
    static final int WIN_STATISTICS_COUNT = 7;
    static final int[] PRIZE = new int[]{0, 0, 0, 5000, 50000, 1500000, 2000000000};

    private List<LottoTicket> tickets;


    public LottoGame(int money) {
        if (money < TICKET_PRICE) {
            throw new RuntimeException();
        }
        int ticketCount = money / TICKET_PRICE;
        this.tickets = generateLottoTickets(ticketCount);
    }

    public LottoGame(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public List<String> getTicketsString() {
        List<String> strings = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            strings.add(ticket.toString());
        }
        return strings;
    }

    public List<String> getResultString(String winText) {

        LottoTicket winTicket = new LottoTicket(winText);

        int[] statistics = calculateStatistics(winTicket);
        List<String> resultString = makeStatisticsStrings(statistics);

        double takePercent = calculateTakePercent(statistics);
        String takePercentString = makeTakePercentString(takePercent);
        resultString.add(takePercentString);

        return resultString;
    }

    private List<LottoTicket> generateLottoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    private int[] calculateStatistics(LottoTicket winTicket) {
        int[] statistics = new int[WIN_STATISTICS_COUNT];
        for (LottoTicket ticket : tickets) {
            int matchCount = ticket.countCompareWinNumbers(winTicket);
            statistics[matchCount]++;
        }
        return statistics;
    }

    private List<String> makeStatisticsStrings(int[] statistics) {
        List<String> statisticsStrings = new ArrayList<>();
        for (int i = 3; i <= 6; i++) {
            String resultString = String.format("%d개 일치 (%d원)- %d개", i, PRIZE[i], statistics[i]);
            statisticsStrings.add(resultString);
        }
        return statisticsStrings;
    }

    private double calculateTakePercent(int[] statistics) {
        int consume = tickets.size() * TICKET_PRICE;
        int income = 0;
        for (int i = 0; i < statistics.length; i++) {
            income = income + (statistics[i] * PRIZE[i]);
        }
        return Math.round((double) income / consume * 10000) / 100.0;
    }

    private String makeTakePercentString(double takePercent) {
        return "총 수익률은 " + takePercent + "입니다.";
    }


}
