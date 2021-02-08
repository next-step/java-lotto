package lotto.controller;

import lotto.wrapper.Count;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CheckResultTest {

    @DisplayName("당첨 통계에 따라 수익률을 잘 계산하는지") // => matchresult test로 이관
    @Test
    void calculateWinningRevenue() {
        CheckResult result = new CheckResult(new Count(5),
                Arrays.asList(new Count(2), new Count(0), new Count(0), new Count(0), new Count(0)));
        assertThat(result.calculateWinningRevenue()).isEqualTo(2.0);
    }
}