package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.view.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoResultsTest {

    @Test
    @DisplayName("로또 결과 생성 테스트")
    void lottoResults_create() {
        /* given & when & then */
        assertDoesNotThrow(() -> new LottoResults(List.of(
                WinningCriteria.winningResult(1, false),
                WinningCriteria.winningResult(6, true)))
        );
    }

    @Test
    @DisplayName("로또 당첨 통계 생성 테스트")
    void lottoResults_getWinningStatistics() {
        /* given */
        LottoResults lottoResults = new LottoResults(List.of(
                WinningCriteria.winningResult(1, false),
                WinningCriteria.winningResult(6, true))
        );

        /* when */
        WinningStatistics winningStatistics = new WinningStatistics(lottoResults);

        /* then */
        assertThat(winningStatistics.getRank(WinningCriteria.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("로또 총 수익 테스트")
    void lottoResults_getTotalPrize() {
        /* given */
        LottoResults lottoResults = new LottoResults(List.of(
                WinningCriteria.winningResult(1, false),
                WinningCriteria.winningResult(6, true))
        );

        /* when */
        WinningStatistics winningStatistics = new WinningStatistics(lottoResults);

        /* then */
        assertThat(winningStatistics.getTotalPrize()).isEqualTo(WinningCriteria.FIRST.getPrize());
    }
}
