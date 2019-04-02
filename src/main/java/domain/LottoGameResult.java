package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    private Map<Integer, Integer> gameResult;

    LottoGameResult() {
        gameResult = new HashMap<>();
        gameResult.put(LottoProfit.FIFTH.getNumberOfMatch(), 0);
        gameResult.put(LottoProfit.FOURTH.getNumberOfMatch(), 0);
        gameResult.put(LottoProfit.THIRD.getNumberOfMatch(), 0);
        gameResult.put(LottoProfit.SECOND.getNumberOfMatch(), 0);
        gameResult.put(LottoProfit.FIRST.getNumberOfMatch(), 0);
    }

    public void getMultipleResults(WinningLotto winningLotto, List<Lotto> userLottos) {

        for(Lotto userLotto : userLottos) {
            LottoMatch result = new LottoMatch(winningLotto, userLotto);
            int numberOfMatch = result.getProfit().getNumberOfMatch();
            System.out.println(numberOfMatch);
            if(numberOfMatch >= LottoProfit.valueOf("FIFTH").getNumberOfMatch() ) {
                gameResult.put(numberOfMatch, gameResult.get(numberOfMatch) + 1);
            }
        }
    }

    public Map<Integer, Integer> getGameResult() {
        return gameResult;
    }
}
