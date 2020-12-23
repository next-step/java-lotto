package com.ssabae.nextstep.lotto.domain.lotto.ticketgenerator;

import com.ssabae.nextstep.lotto.domain.lotto.LottoTicket;

/**
 * @author : leesangbae
 * @project : java-lotto
 * @since : 2020-12-18
 */
public class TestLottoTicketGenerator implements LottoTicketGenerator {

    private LottoTicket ticket;

    @Override
    public LottoTicket generate() {
        if (ticket == null) {
            return new LottoTicket("1,2,3,4,5,6");
        }
        return ticket;
    }

    public LottoTicket getTicket() {
        return ticket;
    }

    public void setTicket(LottoTicket ticket) {
        this.ticket = ticket;
    }
}
