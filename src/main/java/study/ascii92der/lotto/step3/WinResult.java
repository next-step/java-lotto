package study.ascii92der.lotto.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinResult {

    public static final double RETURN_DIGITS_VALUE = 100.0;
    public static final int LOTTO_PRICE = 1000;
    private Map<LottoWinner, Integer> result;
    private int buyLottoCount;

    public WinResult() {
        result = new HashMap<>();
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            result.put(lottoWinner, 0);
        }
    }

    public WinResult(List<LottoResult> lottoResults) {
        this();
        for (LottoResult lottoResult : lottoResults) {
            saveLottoResult(lottoResult);
        }
        buyLottoCount = lottoResults.size();
    }

    private void saveLottoResult(LottoResult lottoResult) {
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            saveWinResult(lottoWinner, lottoResult.matchNumberCount());
        }
    }

    public void saveWinResult(LottoWinner lottoWinner, int matchCount) {
        if (lottoWinner.matchNumberCount == matchCount) {
            result.put(lottoWinner, result.get(lottoWinner) + 1);
        }
    }

    public void saveWinResult(LottoWinner lottoWinner) {
        result.put(lottoWinner, result.get(lottoWinner) + 1);
    }

    public int result(LottoWinner lottoWinner) {
        return result.get(lottoWinner);
    }

    public double totalEarningRate() {
        double totalEarnWinnerPrice = 0;
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            totalEarnWinnerPrice += (lottoWinner.winnerPrice * result.get(lottoWinner));
        }
        return Math.floor((totalEarnWinnerPrice / (buyLottoCount * LOTTO_PRICE)) * RETURN_DIGITS_VALUE) / RETURN_DIGITS_VALUE;
    }
}
