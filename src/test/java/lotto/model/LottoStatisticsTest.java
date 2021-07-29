package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LottoStatisticsTest {
    private LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        int payment = 3_000;
        Lottos lottos = Lottos.from(List.of(
                                            Lotto.from(List.of(1, 2, 3, 4, 5, 6)))
                                   );
        lottos.scratch(WinningNumber.from("1, 2, 3, 7, 8, 9"));
        lottoStatistics = LottoStatistics.from(payment, lottos);
    }

    @Test
    @DisplayName("번호가 3개 일치하는 로또가 한장이다")
    void getStatisticsMap() {
        Map<LottoPrize, Integer> statisticsMap = lottoStatistics.getStatisticsMap();
        Integer matchCount = statisticsMap.get(LottoPrize.FOURTH);
        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산한다")
    void getEarningsRate() {
        double earningsRate = lottoStatistics.getEarningsRate();
        Assertions.assertThat(earningsRate).isEqualTo(0.6);
    }
}
