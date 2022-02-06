package stringcalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccumulatorTest {

    @DisplayName("숫자 리스트를 받아 모두 더한 값을 반환한다.")
    @Test
    void Given_숫자_리스트_When_계산_Then_모두_더한_값_반환() {
        final int result = Accumulator.calculate(Arrays.asList(1, 2, 3));

        assertThat(result).isEqualTo(6);
    }
}
