package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("수식 null, 공백 확인")
    @ParameterizedTest
    @NullAndEmptySource
    public void null_공백_확인(String exp) throws Exception {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> stringCalculator.validExpression(exp));
    }

    @DisplayName("수식 숫자 분리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:1:2", "7 - 3:7:3"}, delimiter = ':')
    public void 숫자_분리(String expression, int left, int right) throws Exception {
        assertThat(stringCalculator.extractNumbers(expression)).containsExactly(left, right);
    }

    @DisplayName("수식 숫자 파싱 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3*", "7 - &", "( - & * 12"})
    public void 숫자_분리_예외_발생(String expression) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.extractNumbers(expression));
    }

    @DisplayName("수식 연산자 분리 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2:+", "7 - 3:-", "8 / 2:/", "12 * 231:*"}, delimiter = ':')
    public void 연산자_분리(String expression, String operation) throws Exception {
        assertThat(stringCalculator.extractOperation(expression)).contains(Operation.toOperation(operation));
    }

    @DisplayName("수식 연산자 파싱 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 7 3*", "7 123 &", "( - & . 12"})
    public void 연산자_분리_예외_발생(String expression) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.extractOperation(expression));
    }

    @DisplayName("수식 연산")
    @ParameterizedTest
    @MethodSource("sampleParams")
    public void 수식_연산(List<Integer> numbers, String operations, int result) throws Exception {
        assertThat(stringCalculator.calculate(numbers, Operation.toOperation(operations))).isEqualTo(result);
    }

    static Stream<Arguments> sampleParams() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2), "+", 3),
                Arguments.of(Arrays.asList(3, 6), "+", 9)
        );
    }

//    @ParameterizedTest
//    @CsvSource(value = {"1 + 2 + 3:6", "12 + 22 - 3:31", "6 * 2 - 7:5", "8 / 4 - 1:1", "8 / 4 - 4:-2"}, delimiter = ':')
//    public void 둘_이상의_연산자_계산_테스트(String exp, int result) throws Exception {
//        stringCalculator = new StringCalculator();
//        stringCalculator.readExpression(exp);
//        assertThat(stringCalculator.calculate()).isEqualTo(result);
//
//    }
//
//    @DisplayName("유효한 연산자가 아닐 경우, IllegalArgumentException")
//    @ParameterizedTest
//    @CsvSource(value = {"1 + 2 & 3", "12 ; 22 - 3", "6 * 2 ) 7", "8 / 4 $ 1"}, delimiter = ':')
//    public void 유효한_연산자_테스트(String exp) throws Exception {
//        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.readExpression(exp));
//    }
}
