package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoController {

    public List<LottoTicket> generateTickets(int ticketCnt, LottoTicketGenerator lottoTicketGenerator){
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCnt; i++) {
            LottoTicket lottoTicket = lottoTicketGenerator.generateNumberList();
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    public LottoResult start(LottoTickets lottoTickets, LottoTicket winningTicket){
        Map<Rank, Long> rankMap = lottoTickets.getRankMap(winningTicket);
        return new LottoResult(rankMap);
    }
}
