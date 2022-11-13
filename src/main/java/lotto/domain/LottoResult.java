package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Integer, Integer> lottoResult = new HashMap<>();


    public LottoResult(List<Lotto> lottos, WinningNumber winningNumber) {

        for (int i= 3; i<=6 ;i++){
            lottoResult.put(i,0);
        }

        for (Lotto lotto : lottos) {
            int count = winningNumber.countWinning(lotto.getLotto());

            if (3<=count && count<=6) {
                lottoResult.put(count, lottoResult.get(count)+1);
            }
        }
    }

    public Map<Integer, Integer> getLottoResult() {
        return lottoResult;
    }

}
