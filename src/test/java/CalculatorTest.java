import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("계산기 테스트")
public class CalculatorTest {

    @DisplayName("입력 값이 NULL이거나 공백일 경우 IllegalArgumentException이 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void checkNull_And_EmptyString(String input) {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
           calculator.calculate(input);
        });
    }

    @DisplayName("분할된 문자열을 숫자와 연산기호에 넣는다.")
    @Test
    void setNumbersAndOperations() {
        Calculator calculator = new Calculator();
        calculator.calculate("2 + 3 * 4 / 2");

        Assertions.assertThat(calculator.getNumbers().getLengthOfNumbers()).isEqualTo(4);
        Assertions.assertThat(calculator.getOperations().getLengthOfOperations()).isEqualTo(3);
    }

    @DisplayName("+,-,*,/를 제외한 연산 기호가 입력될 경우 예외가 발생한다.")
    @Test
    void checkOperation() {
        Calculator calculator = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            calculator.calculate("5 ^ 3");
        });
    }

    @DisplayName("문자열로 입력된 두 숫자를 더한다.")
    @Test
    void add() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1 + 2");
        Assertions.assertThat(result).isEqualTo(3);
    }

    @DisplayName("문자열로 입력된 두 숫자를 뺀다.")
    @Test
    void subtract() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("1 - 2");
        Assertions.assertThat(result).isEqualTo(-1);
    }

    @DisplayName("문자열로 입력된 두 숫자를 곱한다.")
    @Test
    void multiply() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("2 * 3");
        Assertions.assertThat(result).isEqualTo(6);
    }

    @DisplayName("문자열로 입력된 두 숫자를 나눈다.")
    @Test
    void divide() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("7 / 5");
        Assertions.assertThat(result).isEqualTo(1);
    }

    @DisplayName("문자열로 입력된 여러 숫자들을 각 연산 기호에 맞게 계산한다.")
    @Test
    void sum() {
        Calculator calculator = new Calculator();
        int result = calculator.calculate("2 + 3 * 4 / 2");
        Assertions.assertThat(result).isEqualTo(10);
    }
}
