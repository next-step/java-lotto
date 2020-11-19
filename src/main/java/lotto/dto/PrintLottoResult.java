package lotto.dto;

import lotto.domain.LottoRank;
import lotto.domain.LottoStatistics;

import java.math.BigDecimal;
import java.util.*;

public class PrintLottoResult {

    private static final Long DEFAULT_COUNT = 0L;

    private final BigDecimal profitRate;
    private final List<PrintLottoResultValue> statisticsValues;

    private static final List<LottoRank> PRINT_STATISICS_RANK = Arrays.asList(
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST);


    private PrintLottoResult(BigDecimal profitRate, List<PrintLottoResultValue> statisticsValues) {
        this.profitRate = profitRate;
        this.statisticsValues = statisticsValues;
    }

    public static PrintLottoResult of(LottoStatistics lottoStatistics) {
        List<PrintLottoResultValue> values = new ArrayList<>();

        PRINT_STATISICS_RANK.forEach(lottoRank -> values.add(
                PrintLottoResultValue.of(lottoRank,
                                         getCountByLottoRank(lottoStatistics.getLottoRankCountMap(), lottoRank)))
        );

        return new PrintLottoResult(lottoStatistics.calculateProfitRate(), values);
    }

    private static Long getCountByLottoRank(Map<LottoRank, Long> lottoRankCountMap, LottoRank lottoRank) {
        if (Objects.isNull(lottoRankCountMap.get(lottoRank))) {
            return DEFAULT_COUNT;
        }
        return lottoRankCountMap.get(lottoRank);
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public List<PrintLottoResultValue> getStatisticsValue() {
        return statisticsValues;
    }
}
