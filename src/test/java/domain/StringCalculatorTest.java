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
        Numbers numbers = stringCalculator.extractNumbers(expression);
        assertThat(numbers.isContain(left)).isTrue();
        assertThat(numbers.isContain(right)).isTrue();
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
        assertThat(stringCalculator.extractOperation(expression).isContain(Operator.toOperation(operation))).isTrue();
    }

    @DisplayName("수식 연산자 파싱 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 7 3*", "7 123 &", "( - & . 12"})
    public void 연산자_분리_예외_발생(String expression) throws Exception {
        assertThatIllegalArgumentException().isThrownBy(() -> stringCalculator.extractOperation(expression));
    }

    @DisplayName("수식 연산 테스트")
    @ParameterizedTest
    @MethodSource("sampleParams")
    public void 수식_연산(List<Integer> numbers, List<Operator> operators, int result) throws Exception {
        assertThat(stringCalculator.calculate(new Numbers(numbers), new Operations(operators))).isEqualTo(result);
    }

    static Stream<Arguments> sampleParams() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2), Arrays.asList(Operator.toOperation("+")), 3),
                Arguments.of(Arrays.asList(3, 6), Arrays.asList(Operator.toOperation("+")), 9)
        );
    }

    @DisplayName("둘 이상의 연산자 계산 테스트")
    @ParameterizedTest
    @MethodSource("operationMoreThanTwo")
    public void 둘_이상의_연산자_계산_테스트(List<Integer> numbers, List<Operator> operators, int result) throws Exception {
        stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate(new Numbers(numbers), new Operations(operators))).isEqualTo(result);
    }

    static Stream<Arguments> operationMoreThanTwo() throws Throwable {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)
                        , Arrays.asList(Operator.PLUS, Operator.PLUS, Operator.PLUS, Operator.PLUS), 15),
                Arguments.of(Arrays.asList(3, 6, 7, 3)
                        , Arrays.asList(Operator.PLUS, Operator.SUBTRACT, Operator.MULTIPLY), 6),
                Arguments.of(Arrays.asList(123, 9, 3, 2)
                        , Arrays.asList(Operator.SUBTRACT, Operator.SUBTRACT, Operator.SUBTRACT), 109),
                Arguments.of(Arrays.asList(36, 6, 5, 3)
                        , Arrays.asList(Operator.DIVIDE, Operator.SUBTRACT, Operator.PLUS), 4),
                Arguments.of(Arrays.asList(84, 12, 75, 9)
                        , Arrays.asList(Operator.DIVIDE, Operator.SUBTRACT, Operator.PLUS), -59)
        );
    }
}

