package lotto.utils;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoStatisticsResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsCalculatorTest {

    @DisplayName("당첨 로또와 로또 목록으로 통계를 계산하면, 통계 결과를 반환해야 한다.")
    @Test
    void calculateStatistics() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = List.of(
                Lotto.from(List.of(1, 2, 3, 7, 8, 9)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12))
        );
        LottoStatisticsResult actual = LottoStatisticsCalculator.calculateStatistics(winningLotto, lottos);
        assertThat(actual).isEqualTo(
                LottoStatisticsResult.from(
                        List.of(LottoRank.FOURTH, LottoRank.NONE)
                )
        );
        assertThat(actual.getProfit()).isEqualTo(250);
    }

}
