package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorNumberTest {

    @DisplayName("계산기 번호 정상 생성")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void create(int expected) {
        int actual = new CalculatorNumber(expected).getNumber();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("계산기 번호 덧셈 정상 동작")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "10,20,30"})
    void addCalculatorNumber(int number1, int number2, int expected) {
        CalculatorNumber calculatorNumber1 = new CalculatorNumber(number1);
        CalculatorNumber calculatorNumber2 = new CalculatorNumber(number2);
        int actual = calculatorNumber1.add(calculatorNumber2).getNumber();

        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("음수 일때 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void createFailByNagativeNumber(int number) {
        assertThatIllegalArgumentException().isThrownBy(() -> new CalculatorNumber(number));
    }
}