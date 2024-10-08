package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @Test
    @DisplayName("winningStatistics 메서드가 올바른 로또 통계 정보를 반환한다.")
    void winningStatisticsTest() {
        var lottoResults = List.of(
                List.of(1, 2, 3, 4, 5, 6)
                , List.of(10, 20, 30, 40, 50, 60)
                , List.of(100, 200, 300, 400, 500, 600)
        );
        var lastWeekWinningNumbers = List.of(1, 2, 3, 4, 5, 100);
        var result = LottoStatistics.winningStatistics(lottoResults, lastWeekWinningNumbers);
        assertThat(result.getWinningResults().get(2).getCount())
                .isEqualTo(1);
    }
}