package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private final Map<LottoRank, Integer> chart;

    {
        chart = new HashMap<>();
        chart.put(LottoRank.BLANK, 0);
        chart.put(LottoRank.FOURTH, 0);
        chart.put(LottoRank.THIRD, 0);
        chart.put(LottoRank.SECOND, 0);
        chart.put(LottoRank.FIRST, 0);
    }

    public void increase(LottoRank lottoRank) {
        chart.put(lottoRank, chart.get(lottoRank) + 1);
    }

    public int getMatchCount(LottoRank lottoRank) {
        return chart.get(lottoRank);
    }

    public Map<LottoRank, Integer> getChart() {
        return Collections.unmodifiableMap(chart);
    }
}
