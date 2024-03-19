package calculator;

import calculator.domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    final String[] operand = new String[]{"2", "+", "3", "*", "4", "/", "2"};



    @DisplayName("입력받은 문자열에 대한 수식을 계산한다")
    @Test
    void calculate() {
        int result = Calculator.calculate(operand);
        assertThat(result).isEqualTo(10);
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class 입력받은_문자열은 {

        Stream<Arguments> validate() {
            return Stream.of(
                    Arguments.arguments(new String[]{"2", "+"},1),
                    Arguments.arguments(new String[]{"2", "+", "3", "*", "4", "/"},1)

            );
        }

        @DisplayName("길이는 3이상이면서 홀수 크기여야 한다.")
        @ParameterizedTest
        @MethodSource()
        void validate(String[] invalidExpression,int i) {
            assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(invalidExpression));
        }

        @DisplayName("입력받은 문자열 배열의 홀수번째 위치에는 숫자가 입력되어야 한다.")
        @ParameterizedTest
        @CsvSource(value = {"0:%", "2:-", "4:+"}, delimiter = ':')
        void classifyOperands(int index, String invalidValue) {
            operand[index] = invalidValue;
            assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> Calculator.calculate(operand));
        }

        @DisplayName("입력받은 문자열 배열의 짝수번째 위치에는 사칙 연산 기호가 입력되어야 한다.")
        @ParameterizedTest
        @CsvSource(value = {"1:%", "3:0", "5:^"}, delimiter = ':')
        void classifyOperators(String invalidValue) {
            operand[1] = invalidValue;
            assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate(operand));
        }

        @DisplayName("입력받은 문자열이 숫자위치에 숫자가 없을 경우 NumberFormatException 을 발생시킨다.")
        @Test
        void calculateThrowExceptionWhenInvalidTargets() {
            final String[] targets = new String[]{"3", "-", "2", "+", "ㅁㄴㅇㄹㅁㄴㅇㄹ"};
            assertThatExceptionOfType(NumberFormatException.class)
                    .isThrownBy(() -> Calculator.calculate(targets));
        }
    }
}
