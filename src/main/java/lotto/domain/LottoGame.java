package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    static final int TICKET_PRICE = 1000;
    static final int WIN_STATISTICS_COUNT = 7;
    private List<LottoTicket> tickets;


    public LottoGame(int money) {
        int ticketCount = money / TICKET_PRICE;
        this.tickets = generateLottoTickets(ticketCount);
    }

    public LottoGame(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }


    public List<String> getToStringTickets() {
        List<String> strings = new ArrayList<>();
        for (LottoTicket ticket : tickets) {
            strings.add(ticket.toString());
        }
        return strings;
    }

    public int[] getWinStatistics(String winText) {
        int[] statistics = new int[WIN_STATISTICS_COUNT];

        LottoTicket winTicket = new LottoTicket(winText);
        for(LottoTicket ticket : tickets) {
            int matchCount = ticket.countCompareWinNumbers(winTicket);
            statistics[matchCount]++;
        }

        return statistics;
    }


    private List<LottoTicket> generateLottoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

}
