import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @Test
    @DisplayName("콤마 또는 콜론 구분자를 기준으로 분리한 각 숫자의 합을 리턴한다")
    public void sumAndSplitReturnsSumOfNumbersInString() {
        int result = StringAddCalculator.sumAndSplit("1,2:3");

        assertThat(result).isEqualTo(6);
    }
}
