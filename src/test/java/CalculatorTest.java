import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {
    @DisplayName("덧셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:3", "5:3:8", "0:0:0","12:87:99"}, delimiter = ':')
    public void 덧셈_테스트(int leftNum, int rightNum, int result) throws Exception {
        assertThat(Calculator.plus(leftNum, rightNum)).isEqualTo(result);
    }

    @DisplayName("뺄셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:-1", "5:3:2", "0:0:0","12:87:-75"}, delimiter = ':')
    public void 뺄셈_테스트(int leftNum, int rightNum, int result) throws Exception {
        assertThat(Calculator.subtract(leftNum, rightNum)).isEqualTo(result);
    }

    @DisplayName("곱셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:2:2", "5:3:15", "0:0:0","12:87:1044"}, delimiter = ':')
    public void 곱셈_테스트(int leftNum, int rightNum, int result) throws Exception {
        assertThat(Calculator.multiply(leftNum, rightNum)).isEqualTo(result);
    }

    @DisplayName("덧셈 연산을 테스트한다.")
    @ParameterizedTest
    @CsvSource(value = {"4:2:2", "9:3:3", "12:1:12","1044:87:12"}, delimiter = ':')
    public void 나눗셈_테스트(int leftNum, int rightNum, int result) throws Exception {
        assertThat(Calculator.divide(leftNum, rightNum)).isEqualTo(result);
    }
}
