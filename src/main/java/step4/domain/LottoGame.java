package step4.domain;

import step4.domain.lotto.Lotto;
import step4.domain.lotto.LottoNumber;
import step4.domain.lotto.LottoTickets;
import step4.domain.lotto.WinningLotto;
import step4.domain.prize.PrizeCount;
import step4.view.InputView;

import java.util.ArrayList;
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

    //public static LottoGame create(PurchaseInfo purchaseInfo) {
    public static LottoGame create(PurchaseInfo purchaseInfo, List<Lotto> selfChosenLottos) {
        LottoTickets lottoTicketsInner = LottoNumber.issueLotto(purchaseInfo.getBoughtLottoCount());
        // self chosen numbers.
        //List<Lotto> selfChosenLottos = createSelfChoosenLottos(purchaseInfo);
        lottoTicketsInner.add(selfChosenLottos);

        return new LottoGame(lottoTicketsInner);
    }

    private static List<Lotto> createSelfChoosenLottos(PurchaseInfo purchaseInfo) {
        // set
        List<Lotto> selfChosenLottos = new ArrayList<>();
        for (int i = 0; i < purchaseInfo.getSelfChooseCount(); i++) {
            selfChosenLottos.add(new Lotto(InputView.inputChooseNumbersForSelf()));
        }
        return selfChosenLottos;
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
