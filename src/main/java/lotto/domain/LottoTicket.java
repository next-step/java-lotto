package lotto.domain;

import lotto.domain.exception.NotValidLottoTicketException;

public class LottoTicket {

    private int ticketQuantity;

    public LottoTicket(int ticketQuantity) {
        if(ticketQuantity <= 0){
            throw new NotValidLottoTicketException();
        }
        this.ticketQuantity = ticketQuantity;
    }

    public int getTicketQuantity() {
        return ticketQuantity;
    }
}
