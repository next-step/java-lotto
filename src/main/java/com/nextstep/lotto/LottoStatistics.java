package com.nextstep.lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoStatistics {
    private Map<LottoWinning, Integer> result = new HashMap<>();

    public void addCount(LottoWinning lottoWinning) {
        int count = 0;
        if (result.containsKey(lottoWinning)) {
            count = result.get(lottoWinning);
        }
        result.put(lottoWinning, count + 1);
    }

    public int getCount(LottoWinning lottoWinning) {
        if (result.containsKey(lottoWinning)) {
            return result.get(lottoWinning);
        }
        return 0;
    }
}
