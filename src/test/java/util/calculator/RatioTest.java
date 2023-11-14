package util.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.within;

public class RatioTest {
    @Test
    @DisplayName("[Ratio.ratio] 정수 비 계산")
    public void intRatio() {
        assertThat(Ratio.ratio(4, 2))
                .isCloseTo(2.0, within(0.001));
    }

    @Test
    @DisplayName("[Ratio.ratio] 실수 비 계산")
    public void realRatio() {
        assertThat(Ratio.ratio(3, 2))
                .isCloseTo(1.5, within(0.001));
    }
}
