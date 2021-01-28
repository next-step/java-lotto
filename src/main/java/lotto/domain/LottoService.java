package lotto.domain;

import lotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private List<LottoTicket> lottoTickets;

    public LottoService() {
        lottoTickets = new ArrayList<>();
    }

    public void buyLottoTickets(int numberOfTickets){
        for(int i = 0; i < numberOfTickets; ++i){
            lottoTickets.add(new LottoTicket());
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}
