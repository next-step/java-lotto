import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @DisplayName("두 숫자와 사이에 연산자를 입력 시 계산값을 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "1 + 1, 2",
        "13 - 34, -21",
        "2 * 3, 6",
        "3 / 2, 1"
    })
    void returnResult_whenInputTwoNumsAndOperator(String input, int expectResult) {
        //when
        int result = Calculator.calculate(input);
        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @DisplayName("세 개 이상의 숫자와 연산자를 입력 시 계산값을 반환한다.")
    @ParameterizedTest
    @CsvSource({
        "1 + 1 - 1, 1",
        "4 / 2 * 2 + 3, 7",
        "2 * 3 - 1 / 5 * 8, 8",
    })
    void returnResult_whenMultipleNumsAndOperators(String input, int expectResult) {

        //when
        int result = Calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(expectResult);
    }

    @DisplayName("빈 값을 입력 시 예외처리한다.")
    @NullSource
    @ValueSource(strings = { "", " " })
    @ParameterizedTest
    void returnException_whenNullOrEmptyString(String input) {
        //given
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0으로 나눌 시 예외처리한다.")
    @Test
    void returnException_whenDivideByZero() {
        //given
        String input = "3 / 0";
        //when
        assertThatThrownBy(() -> {
            int answer = Calculator.calculate(input);
        }).isInstanceOf(ArithmeticException.class);
    }
}
