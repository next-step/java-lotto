package lotto.model;

import lotto.prize.LottoPrize;
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
        int payment = 5_000;
        Lottos lottos = Lottos.from(List.of(Lotto.from("1, 2, 3, 8, 9, 10"),
                                            Lotto.from("1, 2, 3, 4, 8, 9"),
                                            Lotto.from("1, 2, 3, 4, 5, 8"),
                                            Lotto.from("1, 2, 3, 4, 5, 7"),
                                            Lotto.from("1, 2, 3, 4, 5, 6")));
        WinningLotto winningLotto = WinningLotto.from("1, 2, 3, 4, 5, 6", "7");
        lottoStatistics = LottoStatistics.from(payment, winningLotto.matchResults(lottos));
    }

    @Test
    @DisplayName("번호가 6개 일치하는 로또가 한장이다")
    void first() {
        Map<LottoPrize, Integer> statisticsMap = lottoStatistics.getStatisticsMap();
        Integer matchCount = statisticsMap.get(LottoPrize.FIRST);
        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("번호가 5개, 보너스 번호가 1개 일치하는 로또가 한장이다")
    void second() {
        Map<LottoPrize, Integer> statisticsMap = lottoStatistics.getStatisticsMap();
        Integer matchCount = statisticsMap.get(LottoPrize.SECOND);
        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("번호가 5개 일치하는 로또가 한장이다")
    void third() {
        Map<LottoPrize, Integer> statisticsMap = lottoStatistics.getStatisticsMap();
        Integer matchCount = statisticsMap.get(LottoPrize.THIRD);
        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("번호가 4개 일치하는 로또가 한장이다")
    void fourth() {
        Map<LottoPrize, Integer> statisticsMap = lottoStatistics.getStatisticsMap();
        Integer matchCount = statisticsMap.get(LottoPrize.FOURTH);
        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("번호가 3개 일치하는 로또가 한장이다")
    void fifth() {
        Map<LottoPrize, Integer> statisticsMap = lottoStatistics.getStatisticsMap();
        Integer matchCount = statisticsMap.get(LottoPrize.FIFTH);
        Assertions.assertThat(matchCount).isEqualTo(1);
    }

    @Test
    @DisplayName("수익률을 계산한다")
    void getEarningsRate() {
        double earningsRate = lottoStatistics.getEarningsRate();
        Assertions.assertThat(earningsRate).isEqualTo(406311.0);
    }
}
