package study.ascii92der.lotto.step3n4;

import java.util.*;

public class WinResult {

    public static final int LOTTO_PRICE = 1000;
    private Map<LottoWinner, Integer> result;
    private final int buyLottoCount;

    public WinResult(List<Lotto> lottos, List<String> winnerNumberList) {
        init();
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResults.add(new LottoResult(lotto, winnerNumberList));
        }

        for (LottoResult lottoResult : lottoResults) {
            saveLottoResult(lottoResult);
        }
        buyLottoCount = lottoResults.size();

    }

    private void init() {
        result = new HashMap<>();
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            result.put(lottoWinner, 0);
        }
    }

    private void saveLottoResult(LottoResult lottoResult) {
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            saveWinResult(lottoWinner, lottoResult.matchNumberCount());
        }
    }

    private void saveWinResult(LottoWinner lottoWinner, int matchCount) {
        if (lottoWinner.getMatchNumberCount() == matchCount) {
            result.put(lottoWinner, result.get(lottoWinner) + 1);
        }
    }

    public int result(LottoWinner lottoWinner) {
        return result.get(lottoWinner);
    }

    public double totalEarningRate() {
        double totalEarnWinnerPrice = 0;
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            totalEarnWinnerPrice += (lottoWinner.getWinnerPrice() * result.get(lottoWinner));
        }
        return totalEarnWinnerPrice / (buyLottoCount * LOTTO_PRICE);
    }
}
