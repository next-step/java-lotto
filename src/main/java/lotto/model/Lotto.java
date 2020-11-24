package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lotto {
    private final LottoTickets lottoTickets;

    public Lotto(int ticketCount){
        this.lottoTickets = LottoTickets.of(ticketCount);
    }

    public LottoTickets getLottoTickets(){
        return lottoTickets;
    }
}
