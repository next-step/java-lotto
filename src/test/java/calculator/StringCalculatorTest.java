package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StringCalculatorTest {

//    사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
//    입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
//    나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
//    문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
//    예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.

    @Test
    @DisplayName("문자열 공백 분리 테스트")
    void inputSplitSpaceTest(){
        // Given
        String input = "2 + 3 * 4 / 2";
        int expectedSize = 7;

        // When
        String[] actual = StringCalculator.splitWithSpace(input);

        // Then
        assertThat(actual).hasSize(expectedSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "5,5,10"}, delimiter = ',')
    @DisplayName("덧셈 테스트")
    void sumTest(int numberA, int numberB, int expectedResult){
        // When
        int actual = StringCalculator.sum(numberA, numberB);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"2,1,1", "4,5,-1"}, delimiter = ',')
    @DisplayName("뺄셈 테스트")
    void differenceTest(int numberA, int numberB, int expectedResult){
        // When
        int actual = StringCalculator.difference(numberA, numberB);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,1,1", "9,0,0"}, delimiter = ',')
    @DisplayName("곱셈 테스트")
    void productTest(int numberA, int numberB, int expectedResult){
        // When
        int actual = StringCalculator.product(numberA, numberB);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,2,2", "9,2,4"}, delimiter = ',')
    @DisplayName("나눗셈 테스")
    void quotientTest(int numberA, int numberB, int expectedResult){
        // When
        int actual = StringCalculator.quotient(numberA, numberB);

        // Then
        assertThat(actual).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @NullSource
    @DisplayName("null 입력값 예외 테스트")
    void nullInputThrowExceptionTest(String input){
        assertThatThrownBy(() -> {
            StringCalculator.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 null이면 안됩니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("빈공간 입력값 예외 테스트")
    void blankInputThrowExceptionTest(String input){
        assertThatThrownBy(() -> {
            StringCalculator.validateInput(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력값은 빈공간이면 안됩니다.");
    }

    @Test
    @DisplayName("올바르지 않은 수식 예외 테스트")
    void unavailableMathExpressionThrowExceptionTest(){
        String input = "2 + 3 -";
        String[] inputArray = StringCalculator.splitWithSpace(input);

        assertThatThrownBy(() -> {
            StringCalculator.validateExpression(inputArray);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("올바른 수식이 아닙니다.");
    }
}
