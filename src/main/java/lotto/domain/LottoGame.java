package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    static final int TICKET_PRICE = 1000;

    private List<LottoTicket> tickets;
    private LottoStatistics statistics;

    private LottoGame(List<LottoTicket> tickets) {
        this.tickets = tickets;
        this.statistics = new LottoStatistics();
    }

    public static LottoGame of(int money) {
        if (money < TICKET_PRICE) {
            throw new IllegalArgumentException();
        }
        int ticketCount = money / TICKET_PRICE;
        List<LottoTicket> tickets = generateLottoTickets(ticketCount);

        return new LottoGame(tickets);
    }

    public static LottoGame of(int money, List<String> ticketTexts) {
        int manualTicketCount = ticketTexts.size();
        int autoTicketCount = (money / TICKET_PRICE) - manualTicketCount;
        if (isMoneyNotEnough(money, autoTicketCount)) {
            throw new IllegalArgumentException();
        }

        List<LottoTicket> tickets = ticketTexts.stream()
                .map(text -> new LottoTicket(text))
                .collect(Collectors.toList());
        tickets.addAll(generateLottoTickets(autoTicketCount));

        return new LottoGame(tickets);
    }

    private static boolean isMoneyNotEnough(int money, int autoTicketCount) {
        return (money < TICKET_PRICE || autoTicketCount < 0);
    }

    public List<String> getTicketsString() {
        List<String> strings = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            strings.add(ticket.toString());
        }
        return strings;
    }

    private static List<LottoTicket> generateLottoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    public void doGame(String winText, int bonus) {
        calculateWinCounts(new WinTicket(winText, bonus));
        calculateWinPercent();
    }

    private void calculateWinCounts(WinTicket winTicket) {
        for (LottoTicket ticket : tickets) {
            Rank rank = winTicket.calculateRank(ticket);
            statistics.updateWinCounts(rank);
        }
    }

    private void calculateWinPercent() {
        BigDecimal consume = new BigDecimal(tickets.size() * TICKET_PRICE);
        statistics.updateWinPercent(consume);
    }


    public LottoStatistics getLottoStatistics() {
        return this.statistics;
    }
}
