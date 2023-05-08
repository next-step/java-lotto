package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoStaticsTest {
    @Test
    @DisplayName("통계 표현")
    void statics() {
        List<WinningCount> result = Arrays.asList(WinningCount.THREE, WinningCount.FOUR
                , WinningCount.FIVE, WinningCount.FIVE, WinningCount.SIX);

        Map<WinningCount, Integer> expected = new HashMap<>();
        expected.put(WinningCount.THREE, 1);
        expected.put(WinningCount.FOUR, 1);
        expected.put(WinningCount.FIVE, 2);
        expected.put(WinningCount.FIVE_WITH_BONUS_BALL, 0);
        expected.put(WinningCount.SIX, 1);

        LottoStatics statics = new LottoStatics(5_000, result);

        assertThat(statics.getStatistics()).isEqualTo(expected);
    }

    @Test
    @DisplayName("수익률")
    void rate() {
        List<WinningCount> result = Arrays.asList(WinningCount.THREE);

        LottoStatics statics = new LottoStatics(14000, result);

        assertThat(statics.getRate()).isEqualTo("0.35");
    }
}
