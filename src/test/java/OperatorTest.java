import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @DisplayName("구분자, 숫자 분리하기")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "//;\\n1;2;3"})
    public void matchDelimiterTest(String text) {
        String[] expected = {"1", "2", "3"};
        assertThat(Operator.matchDelimiter(text)).isEqualTo(expected);
    }
}
