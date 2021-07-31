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
    void yieldTest() {
        Map<LottoRank, Long> data = new HashMap<>();
        data.put(FIRST_PLACE, SIZE_ONE);
        data.put(THREE_PLACE, SIZE_ONE);
        data.put(FOUR_PLACE, SIZE_ONE);
        data.put(FIVE_PLACE, SIZE_ONE);

        LottoStatistics lottoStatistics = new LottoStatistics(data);

        long sumMoney = 2000000000 + 1500000 + 50000 + 5000;
        DivisionNumber expertYield = new DivisionNumber(
                sumMoney,
                new MultiplicationNumber(Lotto.PRICE, lottoStatistics.totalSize())
        );
        DivisionNumber yield = lottoStatistics.yield();

        //noinspection
        assertThat(yield)
                .isEqualTo(
                        expertYield
                );
    }

    @DisplayName("totalSize Test")
    @Test
    void totalSizeTest() {
        Map<LottoRank, Long> data = new HashMap<>();
        data.put(LAST_PLACE, (long) 12);
        data.put(FOUR_PLACE, (long) 100);
        data.put(LottoRank.FIVE_PLACE, (long) 10);

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.totalSize())
                .isEqualTo(122);
    }

    @DisplayName("size Test")
    @Test
    void sizeTest() {
        Map<LottoRank, Long> data = new HashMap<>();
        data.put(FOUR_PLACE, (long) 5);
        data.put(LottoRank.FIVE_PLACE, (long) 10);

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.size(FOUR_PLACE))
                .isEqualTo(5);
        assertThat(lottoStatistics.size(LottoRank.FIVE_PLACE))
                .isEqualTo(10);
    }
}