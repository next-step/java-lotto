package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets){
        this.lottoTickets = lottoTickets;
    }

    public static LottoTickets of(int ticketCount){
        List<LottoTicket> tickets = new ArrayList<>();
        for(int i=0;i<ticketCount;i++){
            tickets.add(new LottoTicket(LottoNumberMaker.makeNumber()));
        }
        return new LottoTickets(tickets);
    }

    public int getTicketCount(){
        return lottoTickets.size();
    }

    public LottoTicket oneOf(int count){
        return lottoTickets.get(count);
    }
}
