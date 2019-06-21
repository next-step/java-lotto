import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AccumulatorTest {
    @Test
    @DisplayName("분리된 숫자의 합을 반환.")
    void accumulateTest() {
        int[] testData = {1, 2, 3};
        int result = 6;
        Assertions.assertThat(Accumulator.accumulate(testData)).isEqualTo(result);
    }
}
