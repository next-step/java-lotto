package step2.domain;

import java.util.List;

public class LottoGame {

    private final PurchaseList purchaseList;
    private final WinningLotto winningLotto;

    public LottoGame(PurchaseList purchaseList, WinningLotto winningLotto) {
        this.purchaseList = purchaseList;
        this.winningLotto = winningLotto;
    }

    public GameResult calculateResult() {
        List<LottoRank> result = purchaseList.calculateRankEach(winningLotto);
        return new GameResult(result);
    }
}
