package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<Prize, Integer> lottoResult;

    public LottoResult(Map<Prize, Integer> lottoResult) {
        this.lottoResult = lottoResult;
    }

    public LottoResult(List<Prize> prizes) {
        Map<Prize, Integer> result = new HashMap<>();
        for (Prize prize: prizes) {
            int count = result.getOrDefault(prize, 0);
            result.put(prize, count + 1);
        }
        lottoResult = result;
    }

    public int getOrZero(Prize prize) {
        return lottoResult.getOrDefault(prize, 0);
    }
}
