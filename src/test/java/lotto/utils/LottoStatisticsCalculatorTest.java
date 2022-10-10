package lotto.utils;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsCalculatorTest {

    @DisplayName("당첨 로또와 로또 목록으로 통계를 계산하면, 통계 결과를 반환해야 한다.")
    @Test
    void calculateStatistics() {
        Lotto winningLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusLottoNumber = new LottoNumber(7);
        List<Lotto> lottos = List.of(
                Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.from(List.of(1, 2, 3, 4, 5, 8)),
                Lotto.from(List.of(1, 2, 3, 4, 7, 8)),
                Lotto.from(List.of(1, 2, 3, 7, 8, 9)),
                Lotto.from(List.of(7, 8, 9, 10, 11, 12)),
                Lotto.from(List.of(17, 18, 19, 20, 21, 22)),
                Lotto.from(List.of(27, 28, 29, 30, 31, 32)),
                Lotto.from(List.of(37, 38, 39, 40, 41, 42)),
                Lotto.from(List.of(7, 8, 9, 40, 41, 42))
        );
        WinningCondition winningCondition = new WinningCondition(winningLotto, bonusLottoNumber);

        LottoStatisticsResult actual = LottoStatisticsCalculator.calculateStatistics(winningCondition, lottos);
        assertThat(actual).isEqualTo(
                LottoStatisticsResult.from(
                        List.of(
                                LottoRank.FIRST,
                                LottoRank.SECOND,
                                LottoRank.THIRD,
                                LottoRank.FOURTH,
                                LottoRank.FIFTH,
                                LottoRank.NONE,
                                LottoRank.NONE,
                                LottoRank.NONE,
                                LottoRank.NONE,
                                LottoRank.NONE
                        )
                )
        );
        assertThat(actual.getProfit()).isEqualTo(203_155.5);
    }

}
