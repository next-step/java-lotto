package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final LottoMchine lottoMchine;

    public static final int LOTTO_GAME_FEE = 1000;

    public LottoStore(LottoMchine lottoMchine) {
        this.lottoMchine = lottoMchine; 
    }

    public List<LottoTicket> buy(int money) {
        if (money < LOTTO_GAME_FEE) {
            throw new IllegalArgumentException(String.format("로또 한개당 가격은 %d원입니다.", LOTTO_GAME_FEE));
        }
        
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_GAME_FEE; i++) {
            tickets.add(createTicket());
        }
        
        return tickets;
    }

    private LottoTicket createTicket() {
        return lottoMchine.createTicket();
    }

}
