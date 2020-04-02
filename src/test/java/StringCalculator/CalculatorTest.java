package StringCalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

public class CalculatorTest {


    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName(" ',' / ':' / '커스텀 구분자' 가 아닌경우 에러 출력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1!2#3"})
    void validate(String input) {
        assertThatThrownBy(
                () -> calculator.execute(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수 체크")
    @ParameterizedTest
    @ValueSource(ints = {-1})
    void checkBiggerThanZero(int input) {
        assertThatThrownBy(
                () -> calculator.checkBiggerThanZero(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName(", 또는 : 구분자를 사용해 합 구하기 테스트")
    @Test
    void sum() {
        String input = "1,2,3";
        int sum = calculator.execute(input);
        assertThat(sum).isEqualTo(6);
    }

    @DisplayName(" 커스텀 구분자를 사용해 합 구하기 테스트")
    @Test
    void customSum() {
        String input = "//;\n1;2;3";
        int sum = calculator.execute(input);
        assertThat(sum).isEqualTo(6);
    }

}
