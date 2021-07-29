package lotto.domain;

import lotto.util.number.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.domain.LottoRank.*;
import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    private static final long SIZE_ONE = 1;

    @DisplayName("yield Test")
    @Test
    void yield() {

        Map<LottoRank, Long> data = new HashMap<>();
        data.put(FIRST_PLACE, SIZE_ONE);
        data.put(SECOND_PLACE, SIZE_ONE);
        data.put(THREE_PLACE, SIZE_ONE);
        data.put(FOUR_PLACE, SIZE_ONE);

        LottoStatistics lottoStatistics = new LottoStatistics(data);

        long sumMoney = 2000000000 + 1500000 + 50000 + 5000;
        DivisionNumber expertYield = new DivisionNumber(
                sumMoney,
                new MultiplicationNumber(Lotto.PRICE, lottoStatistics.totalSize())
        );
        DivisionNumber yield = lottoStatistics.yield();

        assertThat(yield)
                .withFailMessage(String.format("결과가 다릅니다. [%d, %d]", expertYield.longValue(), yield.longValue()))
                .isEqualTo(
                        expertYield
                );
    }

    @DisplayName("count Test")
    @Test
    void count() {
        Map<LottoRank, Long> data = new HashMap<>();
        data.put(THREE_PLACE, (long) 5);
        data.put(LottoRank.FOUR_PLACE, (long) 10);

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.size(THREE_PLACE))
                .isEqualTo(5);
        assertThat(lottoStatistics.size(LottoRank.FOUR_PLACE))
                .isEqualTo(10);
    }
}