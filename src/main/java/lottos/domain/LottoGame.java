package lottos.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private WinningPrizes winningPrizes;
    private int pricePerPiece;

    public LottoGame(WinningPrizes winningPrizes, int pricePerPiece) {
        this.winningPrizes = winningPrizes;
        this.pricePerPiece = pricePerPiece;
    }

    public Lottos start(int purchaseAmount) {
        Shop shop = new Shop(pricePerPiece);
        return shop.issue(purchaseAmount);
    }

    public List<LottoResult> match(Lotto winningLotto, Lottos lottos) {
        Map<Integer, Result> map = groupingByNameOfMatches(winningLotto, lottos);
        List<LottoResult> lottoResults = new ArrayList<>();

        for (int nameOfMatches = 0; nameOfMatches < winningPrizes.size(); nameOfMatches++) {
            int prize = this.winningPrizes.getPrize(nameOfMatches);
            Result result = map.getOrDefault(nameOfMatches, new Result(nameOfMatches, 0));
            LottoResult lottoResult = new LottoResult(prize, result);
            lottoResults.add(lottoResult);
        }

        return lottoResults;
    }

    private Map<Integer, Result> groupingByNameOfMatches(Lotto winningLotto, Lottos lottos) {
        Map<Integer, Result> map = new HashMap<>();

        for (Lotto lotto : lottos.getElements()) {
            int countOfMatches = winningLotto.match(lotto);
            Result result = map.getOrDefault(countOfMatches, new Result(countOfMatches, 0));
            map.put(countOfMatches, new Result(countOfMatches, result.getCountOfMatches() + 1));
        }

        return map;
    }
}
