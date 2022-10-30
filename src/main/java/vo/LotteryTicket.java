package vo;

import java.util.List;

public class LotteryTicket {
    private final List<Integer> ticketNumbers;

    public LotteryTicket(List<Integer> ticketNumbers) {
        this.ticketNumbers = ticketNumbers;
    }

    public List<Integer> getTicketNumbers() {
        return ticketNumbers;
    }
}
