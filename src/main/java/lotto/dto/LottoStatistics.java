package lotto.dto;

import lotto.domain.LottoRank;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class LottoStatistics {

    private static final Long DEFAULT_COUNT = 0L;

    private final BigDecimal profitRate;
    private final List<LottoStatisticsValue> statisticsValues;

    private static final List<LottoRank> PRINT_STATISICS_RANK = Arrays.asList(
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST);


    private LottoStatistics(BigDecimal profitRate, List<LottoStatisticsValue> statisticsValues) {
        this.profitRate = profitRate;
        this.statisticsValues = statisticsValues;
    }

    public static LottoStatistics of(BigDecimal profitRate, List<LottoRank> lottoRanks) {
        List<LottoStatisticsValue> values = new ArrayList<>();

        Map<LottoRank, Long> lottoRankCountMap = lottoRanks.stream()
                .collect(Collectors.groupingBy(lottoRank -> lottoRank, Collectors.counting()));

        PRINT_STATISICS_RANK.forEach(lottoRank -> values.add(
                LottoStatisticsValue.of(lottoRank, getCountByLottoRank(lottoRankCountMap, lottoRank)))
        );

        return new LottoStatistics(profitRate, values);
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

    public List<LottoStatisticsValue> getStatisticsValue() {
        return statisticsValues;
    }
}
