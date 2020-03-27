package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 혹은 null 을 집어넣었을 때 0을 반환한다.")
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(final String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(0);
    }
}
