package step2.domain;

import java.util.List;

public class LottoGame {

    private final PurchaseList purchaseList;
    private final Winner winner;

    public LottoGame(PurchaseList purchaseList, Winner winner) {
        this.purchaseList = purchaseList;
        this.winner = winner;
    }

    public GameResult calculateResult() {
        List<LottoRank> result = purchaseList.calculateRankEach(winner);
        return new GameResult(result);
    }
}
