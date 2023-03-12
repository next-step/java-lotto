package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private int buyLottoPrice;

    private final List<LottoTicket> lottoTickets;

    public LottoMachine(int buyLottoPrice) {
        this.buyLottoPrice = buyLottoPrice;
        this.lottoTickets = buyRandomLotto(buyLottoPrice);
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }

    private List<LottoTicket> buyRandomLotto(int buyLottoPrice){
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for(int i = 0; i < buyLottoPrice / 1000; i++){
            lottoTickets.add(new LottoTicket());
        }

        return lottoTickets;
    }
}
