package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccumulatorTest {

    @DisplayName("계산 테스트")
    @Test
    void 계산_테스트() {
        final int result = Accumulator.calculate(Arrays.asList(1, 2, 3));

        assertThat(result).isEqualTo(6);
    }
}
