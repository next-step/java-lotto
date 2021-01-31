package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MatchResultTest {

    @DisplayName("당첨 통계에 따라 수익률을 잘 계산하는지") // => matchresult test로 이관
    @Test
    void calculateWinningRevenue() {
        MatchResult result = new MatchResult(5, Arrays.asList(2, 0, 0, 0, 0));
        assertThat(result.CalculateWinningRevenue()).isEqualTo(2.0);
    }
}