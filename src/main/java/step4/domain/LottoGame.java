package step4.domain;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.LottoTickets;
import step4.domain.lotto.WinningLotto;
import step4.domain.prize.PrizeCount;

import java.util.List;

/*
 * LottoGame
 * ver. 1.0
 * 2020.05.31
 */
public class LottoGame {

    private LottoTickets lottoTickets;

    private LottoGame(LottoTickets lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public static LottoGame create(PurchaseInfo purchaseInfo, List<Lotto> selfChosenLottos) {
        LottoTickets lottoTickets = LottoNumber.issueLotto(purchaseInfo.getBoughtLottoCount());
        // self chosen numbers.
        lottoTickets.add(selfChosenLottos);
        return new LottoGame(lottoTickets);
    }

    // matching
    public void matchingWinningNumbers(WinningLotto winningLotto) {
        winningLotto.matchingWinningNumbers(lottoTickets);
    }
    // winningResult

    public void totalResult() {
        PrizeCount prizeCount = PrizeCount.getInstance();
        prizeCount.outputWinningResult();
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

}
