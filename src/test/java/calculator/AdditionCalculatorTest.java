package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class AdditionCalculatorTest {

    @ParameterizedTest
    @DisplayName("디폴트구분자로 덧셈 계산하기")
    @CsvSource(value = {"1:2:3=6", "1,2,3=6", "1,2:3=6"}, delimiter = '=')
    void sumDefaultDelimiter(String s, Integer result) {
        AdditionCalculator calculator = AdditionCalculator.from(s);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("커스텀 구분자로 덧셈 계산하기")
    @CsvSource(value = {"//;\\n1;2;3=6", "//a\\n1a2a3a4=10", "//+\\n1+2+3+5=11"}, delimiter = '=')
    void sumCustomDelimiter(String s, Integer result) {
        AdditionCalculator calculator = AdditionCalculator.from(s);
        assertThat(calculator.result()).isEqualTo(result);
    }

    @ParameterizedTest
    @DisplayName("구분자, 숫자 외 값이 있을 시 예외처리")
    @ValueSource(strings = {"1a2a3", "1:2,a", "1,3b4"})
    void 구분자_숫자_외_값이_있을_시_예외처리(String input) {
        AdditionCalculator calculator = AdditionCalculator.from(input);
        assertThatExceptionOfType(AdditionNumberFormatException.class)
            .isThrownBy(() -> calculator.result());

    }

    @ParameterizedTest
    @DisplayName("음수가 있을 시 예외처리")
    @ValueSource(strings = {"1;-1", "-2,3", "3:2,-1"})
    void 음수있을시_예외처리(String input) {
        AdditionCalculator calculator = AdditionCalculator.from(input);
        assertThatExceptionOfType(AdditionIllegalArgumentException.class)
            .isThrownBy(() -> calculator.result());

    }

    @ParameterizedTest
    @DisplayName("null 혹은 빈 값일 경우 0 리턴")
    @NullAndEmptySource
    void null_혹은_빈_값일_경우_0_리턴(String input) {
        AdditionCalculator calculator = AdditionCalculator.from(input);
        assertThat(calculator.result()).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("숫자가 하나일 경우 해당 숫자 리턴")
    @CsvSource(value = {"1=1", "2=2", "10=10"}, delimiter = '=')
    void 숫자가_하나일_경우_해당_숫자_리턴(String input, int result) {
        AdditionCalculator calculator = AdditionCalculator.from(input);
        assertThat(calculator.result()).isEqualTo(result);
    }

}
