import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

    @DisplayName("'a + b'를 입력 시 계산값을 반환한다.")
    @Test
    void returnResult_whenAPlusB() {
        //given
        String aPlusB = "1 + 1";
        int expectedResult = 2;
        Calculator calculator = Calculator.of(aPlusB);
        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("'a - b'를 입력 시 계산값을 반환한다.")
    @Test
    void returnResult_whenAMinusB() {
        //given
        String aMinusB = "13 - 34";
        int expectedResult = -21;
        Calculator calculator = Calculator.of(aMinusB);
        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("'a * b'를 입력 시 계산값을 반환한다.")
    @Test
    void returnResult_whenAPowerB() {
        //given
        String aPowerB = "2 * 3";
        int expectedResult = 6;
        Calculator calculator = Calculator.of(aPowerB);
        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("'a / b'를 입력 시 계산값을 반환한다.")
    @Test
    void returnResult_whenAMultipleB() {
        //given
        String aDivideB = "3 / 2";
        int expectedResult = 1;
        Calculator calculator = Calculator.of(aDivideB);
        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("둘 이상의 연산자를 입력 시 계산값을 반환한다.")
    @Test
    void returnResult_whenMultipleOperators() {
        //given
        String aDivideB = "4 / 2 * 2 + 3";
        int expectedResult = 7;
        Calculator calculator = Calculator.of(aDivideB);
        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("빈 값을 입력 시 예외처리한다.")
    @NullSource
    @ValueSource(strings = { "", " " })
    @ParameterizedTest
    void returnException_whenNullOrEmptyString(String input) {
        //given
        assertThatThrownBy(() -> {
            Calculator calculator = Calculator.of(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
