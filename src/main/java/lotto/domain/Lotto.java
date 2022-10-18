package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private static final int TICKET_AMOUNT = 1000;
    private final int ticketCount;

    private final List<Ticket> ticketList;

    public Lotto(int amount) {
        this.ticketCount = convertAmountToTicketCount(amount);
        this.ticketList = makeTicketList(ticketCount);
    }

    public static int convertAmountToTicketCount(int amount) {
        return amount / TICKET_AMOUNT;
    }

    public static List<Ticket> makeTicketList(int count) {
        List<Ticket> ticketList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Ticket ticket = new Ticket();
            ticketList.add(ticket);
        }
        return ticketList;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }
}
