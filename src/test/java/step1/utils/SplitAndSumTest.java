package step1.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitAndSumTest {
    @Test
    @DisplayName("쉼표 구분자 합")
    public void splitAndSum() {
        int result = SplitAndSum.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }
    @Test
    @DisplayName("쉼표 및 콜론 구분자 합")
    public void splitAndSumWithDefaultDelimiter() {
        int result = SplitAndSum.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자")
    public void splitAndSUmWithCustomDelimiter() {
        int result = SplitAndSum.splitAndSUmWithCustomDelimiter("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 하나")
    public void splitAndSumWithOneValue() {
        assertThat(SplitAndSum.splitAndSum("1")).isEqualTo(1);
        assertThat(SplitAndSum.splitAndSUmWithCustomDelimiter("1")).isEqualTo(1);
    }
}
