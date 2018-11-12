package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private final LottoMachine lottoMchine;

    public static final int LOTTO_GAME_FEE = 1000;

    public LottoStore(LottoMachine lottoMchine) {
        this.lottoMchine = lottoMchine; 
    }

    public List<Lotto> buyTickets(Money won) {
        if (won.isLess(LOTTO_GAME_FEE)) {
            throw new IllegalArgumentException(String.format("금액이 부족합니다. \n 로또 한개당 가격은 %d원입니다.", LOTTO_GAME_FEE));
        }
        
        List<Lotto> tickets = new ArrayList<>();
        int times = won.getGameTImes(LOTTO_GAME_FEE);
        for (int i = 0; i < times; i++) {
            tickets.add(createLotto());
        }
        return tickets;
    }

    public LottoResult checkWinningLotto(String winningNumber, int bonusNumber, List<Lotto> buyedTickets) {
        return check(createWInningLotto(winningNumber, bonusNumber), buyedTickets);
    }

    private LottoResult check(WInningLotto winningLotto, List<Lotto> buyedLottos) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : buyedLottos) {
            int matchCount = winningLotto.howManyMatchBall(lotto);
            boolean bonusCount = winningLotto.hasBonusBall(lotto);
            lottoResult.addResult(LottoPrize.findPrize(matchCount, bonusCount));
        }

        return lottoResult;
    }

    private WInningLotto createWInningLotto(String winningNumber, int bonusNumber) {
        return lottoMchine.createWinningLotto(winningNumber, bonusNumber);
    }

    private Lotto createLotto() {
        return lottoMchine.createLotto();
    }

}
