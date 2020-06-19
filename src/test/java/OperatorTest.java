import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @DisplayName("구분자, 숫자 분리하기")
    @Test
    public void matchDelimiterTest() {
        String value = "1,2:3";
        String[] expected = {"1", "2", "3"};
        assertThat(Operator.matchDelimiter(value)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자, 숫자 분리하기")
    @Test
    public void matchCustomDelimiterTest() {
        String value = "//;\n1;2;3";
        String[] expected = {"1", "2", "3"};
        assertThat(Operator.matchDelimiter(value)).isEqualTo(expected);
    }
}
