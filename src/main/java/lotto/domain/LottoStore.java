package lotto.domain;

import java.util.LinkedList;
import java.util.List;

public class LottoStore {

    private final LottoMachine lottoMchine;

    public static final int LOTTO_GAME_FEE = 1000;

    public LottoStore(LottoMachine lottoMchine) {
        this.lottoMchine = lottoMchine; 
    }

    public List<Lotto> buyTickets(int money) {
        if (money < LOTTO_GAME_FEE) {
            throw new IllegalArgumentException(String.format("로또 한개당 가격은 %d원입니다.", LOTTO_GAME_FEE));
        }
        
        List<Lotto> tickets = new LinkedList<>();
        int times = money / LOTTO_GAME_FEE;
        for (int i = 0; i < times; i++) {
            tickets.add(createLotto());
        }
        return tickets;
    }

    public LottoResult checkWinningLotto(String winningNumber, int bonusNumber, List<Lotto> buyedTickets) {
        return lottoMchine.check(createWInningLotto(winningNumber, bonusNumber), buyedTickets);
    }

    private WInningLotto createWInningLotto(String winningNumber, int bonusNumber) {
        return lottoMchine.createWinningLotto(winningNumber, bonusNumber);
    }

    private Lotto createLotto() {
        return lottoMchine.createLotto();
    }

}
