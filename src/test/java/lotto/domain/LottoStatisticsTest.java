package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {
    @Test
    @DisplayName("getLottoWinningResult 메서드가 올바른 로또 통계 정보를 반환한다.")
    void getLottoWinningResultTest() {
        var lottoResults = List.of(
                new Lotto(Set.of(1, 2, 3, 4, 5, 6)),
                new Lotto(Set.of(7, 8, 9, 10, 11, 12)),
                new Lotto(Set.of(13, 14, 15, 16, 17, 18))
        );
        var lastWeekWinningNumbers = new Lotto(Set.of(1, 2, 3, 4, 5, 18));
        var result = LottoStatistics.getLottoWinningResult(lottoResults, lastWeekWinningNumbers);
        assertThat(result.getWinningResults().get(2).getCount())
                .isEqualTo(1);
    }
}