package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final LottoMchine lottoMchine;

    public LottoStore(LottoMchine lottoMchine) {
        this.lottoMchine = lottoMchine; 
    }

    public List<LottoTicket> buy(int money) {
        if (money < LottoMchine.LOTTO_GAME_FEE) {
            throw new IllegalArgumentException(String.format("로또 한개당 가격은 %d원입니다.", LottoMchine.LOTTO_GAME_FEE));
        }
        
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LottoMchine.LOTTO_GAME_FEE; i++) {
            tickets.add(createTicket());
        }
        
        return tickets;
    }

    private LottoTicket createTicket() {
        return lottoMchine.createTicket();
    }

}
