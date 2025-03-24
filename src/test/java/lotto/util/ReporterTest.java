package lotto.util;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ReporterTest {
    @Test
    void ROI_계산() {
        Map<Integer, Integer> matchNums = Map.of(
                3, 1,
                4, 1,
                5, 1,
                6, 1
        );
        assertThat(Reporter.getROI(matchNums, 1)).isEqualTo(2001555);
    }
}
