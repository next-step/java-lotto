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

    public LottoGame(int money) {
        if (money < TICKET_PRICE) {
            throw new RuntimeException();
        }
        int ticketCount = money / TICKET_PRICE;
        this.tickets = generateLottoTickets(ticketCount);
        this.statistics = new LottoStatistics();
    }

    public LottoGame(List<String> ticketTexts) {
        this.tickets = ticketTexts.stream()
                .map(text -> new LottoTicket(text))
                .collect(Collectors.toList());
        this.statistics = new LottoStatistics();
    }

    public List<String> getTicketsString() {
        List<String> strings = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            strings.add(ticket.toString());
        }
        return strings;
    }

    private List<LottoTicket> generateLottoTickets(int ticketCount) {
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
            Rank rank = ticket.calculateRank(winTicket);
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
