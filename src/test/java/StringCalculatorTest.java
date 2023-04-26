import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("수식 null, 공백 확인")
    @ParameterizedTest
    @NullAndEmptySource
    public void null_공백_확인(String exp) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.readExpression(exp));
    }

    @DisplayName("수식 숫자 분리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:1:2", "7 - 3:7:3"}, delimiter = ':')
    public void 숫자_분리(String exp, int left, int right) throws Exception {
        assertThat(stringCalculator.extractNumbers(exp.split(" "))).containsExactly(left, right);
    }

    @DisplayName("수식 연산자 분리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:+", "7 - 3:-", "8 / 2:/", "12 * 231:*"}, delimiter = ':')
    public void 연산자_분리(String exp, String operation) throws Exception {
        assertThat(stringCalculator.extractOperation(exp.split(" "))).contains(Operation.toOperation(operation));
    }

}
