package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import lotto.view.WinningStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    @DisplayName("당첨 결과가 비어있을 경우 테스트")
    void winningStatistics_emptyLottoResult() {
        /* given & when & then */
        assertThatThrownBy(() -> new WinningStatistics(new LottoResults(Collections.emptyList())))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }
}
