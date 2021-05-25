package study.ascii92der.lotto.step3;

import java.util.HashMap;
import java.util.Map;

public class WinResult {

    private Map<LottoWinner, Integer> result;

    public WinResult() {
        result = new HashMap<>();
        for (LottoWinner lottoWinner : LottoWinner.values()) {
            result.put(lottoWinner, 0);
        }
    }

    public void saveWinResult(LottoWinner lottoWinner) {
        result.put(lottoWinner, result.get(lottoWinner) + 1);
    }

    public int result(LottoWinner lottoWinner) {
        return result.get(lottoWinner);
    }
}
