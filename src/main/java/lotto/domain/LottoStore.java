package lotto.domain;

import lotto.utils.LottoHelper;

import java.util.ArrayList;
import java.util.LinkedList;
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
        
        List<LottoTicket> tickets = new LinkedList<>();
        for (int i = 0; i < money / LOTTO_GAME_FEE; i++) {
            tickets.add(createTicket());
        }
        return tickets;
    }

    public LottoResult checkTickets(String winningNumber, List<LottoTicket> buyedTickets) {
        LottoTicket winningTicket = lottoMchine.createTicket(LottoHelper.convertToBalls(winningNumber));
        return lottoMchine.check(winningTicket, buyedTickets);
    }

    private LottoTicket createTicket() {
        return lottoMchine.createTicket();
    }

}
