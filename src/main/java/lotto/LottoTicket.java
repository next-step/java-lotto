package lotto;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private List<Integer> ticketNumbers;

    public LottoTicket(List<Integer>ticketNumbers){
        this.ticketNumbers = ticketNumbers;

    }

    public List<Integer> getTicketNumbers(){
        return Collections.unmodifiableList(ticketNumbers);
    }
}
