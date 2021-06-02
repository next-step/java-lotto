package study.ascii92der.lotto.step3n4;

import java.util.*;

public class WinResult {

    public static final int LOTTO_PRICE = 1000;
    private final int buyLottoCount;
    private List<LottoResult> lottoResults;

    public WinResult(List<Lotto> lottos, WinningLotto winningLotto) {
        lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResults.add(new LottoResult(lotto, winningLotto));
        }
        buyLottoCount = lottoResults.size();
    }

    public int result(LottoWinner lottoWinner) {
        return (int) lottoResults.stream().filter(
                lottoResult -> lottoResult.result() == lottoWinner).count();
    }

    public double totalEarningRate() {
        double totalEarnWinnerPrice = 0;
        for (LottoResult lottoResult : lottoResults) {
            totalEarnWinnerPrice += lottoResult.result().getWinnerPrice();
        }
        return totalEarnWinnerPrice / (buyLottoCount * LOTTO_PRICE);
    }
}
