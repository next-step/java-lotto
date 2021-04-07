package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final int numberOfLottoTickets;
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoTickets(int numberOfLottoTickets){
        this.numberOfLottoTickets = numberOfLottoTickets;
        buyLottoTickets();
    }

    private void buyLottoTickets(){
        for (int i = 0; i < numberOfLottoTickets; i++) {
            lottoTickets.add(new LottoTicket());
        }
    }

    public List<LottoTicket> getLottoTickets(){
        return lottoTickets;
    }
}
