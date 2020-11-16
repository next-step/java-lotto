package lotto.dto;

import lotto.domain.LottoRank;
import lotto.domain.Lottos;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class LottoStatistics {

    private static final Long DEFAULT_COUNT = 0L;
    private final BigDecimal profitRate;
    private final List<LottoStatisticsValue> statisticsValues;

    private static final List<LottoRank> PRINT_STATISICS_RANK = Arrays.asList(
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST);

    public LottoStatistics(Lottos lottos) {
        List<LottoStatisticsValue> values = new ArrayList<>();

        PRINT_STATISICS_RANK.forEach(lottoRank -> {
            values.add(LottoStatisticsValue.of(lottoRank, getCountByLottoRank(lottos, lottoRank)));
        });

        this.profitRate = lottos.calculateProfitRate();
        this.statisticsValues = values;
    }

    private Long getCountByLottoRank(Lottos lottos, LottoRank lottoRank) {
        Long count = lottos.getStatistics().get(lottoRank);
        return Objects.isNull(count) ? DEFAULT_COUNT : count;
    }

    public BigDecimal getProfitRate() {
        return profitRate;
    }

    public List<LottoStatisticsValue> getStatisticsValue() {
        return statisticsValues;
    }
}
