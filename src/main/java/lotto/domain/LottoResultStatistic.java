package lotto.domain;

import java.util.Map;
import java.util.stream.Collectors;

public class LottoResultStatistic {
    Map<Prize, Integer> lottoResultStatistics;

    public LottoResultStatistic(Map<Prize, Integer> lottoResultStatistics) {
        this.lottoResultStatistics = lottoResultStatistics;
    }
    public String getResult(Prize prize) {
        return String.valueOf(lottoResultStatistics.get(prize));
    }

    public String getAllResult() {
        return lottoResultStatistics.values()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}
