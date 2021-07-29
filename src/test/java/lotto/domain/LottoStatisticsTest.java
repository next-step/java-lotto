package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoStatisticsTest {
    @DisplayName("yield Test")
    @Test
    void yield() {
        Map<LottoRank, Integer> data = new HashMap<>();
        data.put(LottoRank.FIRST_PLACE, 1);
        data.put(LottoRank.SECOND_PLACE, 1);
        data.put(LottoRank.THREE_PLACE, 1);
        data.put(LottoRank.FOUR_PLACE, 1);

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.yield())
                .isEqualTo(
                        new Money(2000000000 + 1500000 + 50000 + 5000)
                );
    }

    @DisplayName("count Test")
    @Test
    void count() {
        Map<LottoRank, Integer> data = new HashMap<>();
        data.put(LottoRank.THREE_PLACE, 5);
        data.put(LottoRank.FOUR_PLACE, 10);

        LottoStatistics lottoStatistics = new LottoStatistics(data);
        assertThat(lottoStatistics.count(LottoRank.THREE_PLACE))
                .isEqualTo(5);
        assertThat(lottoStatistics.count(LottoRank.FOUR_PLACE))
                .isEqualTo(10);
    }
}