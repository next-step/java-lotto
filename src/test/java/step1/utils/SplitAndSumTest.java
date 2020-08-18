package step1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitAndSumTest {
    @Test
    @DisplayName("쉼표 구분자 합")
    void splitAndSum() {
        int result = SplitAndSum.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
}
