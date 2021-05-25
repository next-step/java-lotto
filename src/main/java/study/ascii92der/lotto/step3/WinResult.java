package study.ascii92der.lotto.step3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinResult {

    private Map<LottoWinner, Integer> result;

    public WinResult() {
        result = new HashMap<>();
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            result.put(lottoWinner, 0);
        }
    }

    public WinResult(List<LottoResult> lottoResults) {
        super();
        for (LottoResult lottoResult : lottoResults) {
            saveLottoResult(lottoResult);
        }
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

}
