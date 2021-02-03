package lotto.view;

import java.util.List;
import lotto.domain.Ticket;

public class DataView {

    public static final String LINE_BREAK = "\n";
    public static final String REMIND_LOTTO_COUNT = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";

    public void printLottoPurchaseCount(int manualTicketCount, int autoTicketCount) {
        System.out.println(
            createLottoPurchaseCountString(
                manualTicketCount,
                autoTicketCount
            ));
    }

    public void printGeneratedTickets(List<Ticket> tickets) {
        System.out.println(createGeneratedTicketsString(tickets));
    }

    private StringBuilder createLottoPurchaseCountString(int manualTicketCount,
        int autoTicketCount) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder
            .append(String.format(
                REMIND_LOTTO_COUNT,
                manualTicketCount,
                autoTicketCount
            ));
    }

    private StringBuilder createGeneratedTicketsString(List<Ticket> tickets) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Ticket ticket : tickets) {
            stringBuilder.append(ticket.toString());
            stringBuilder.append(LINE_BREAK);
        }
        return stringBuilder;
    }
}
