package calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class NumberTest {

    @Test
    @DisplayName("Number 생성 - int")
    void createNumberByInt() {
        assertThat(new Number(0)).isEqualTo(new Number(0));
    }

    @Test
    @DisplayName("Number 생성 - String")
    void createNumberByString() {
        assertThat(new Number("0")).isEqualTo(new Number("0"));
    }

    @Test
    @DisplayName("음수가 인자로 들어온 경우 예외 처리")
    void isNegativeException() {
        assertThatThrownBy(() -> new Number(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "숫자가 아닌 문자열이 인자로 들어온 경우 예외 처리")
    @ValueSource(strings = {"", "`"})
    void isNotNumberException(String value) {
        assertThatThrownBy(() -> new Number(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void calculate() {
        Number left = new Number(2);
        Number right = new Number(1);

        assertAll(
                () -> assertThat(left.calculate(Symbol.ADDITION, right)).isEqualTo(new Number(3)),
                () -> assertThat(left.calculate(Symbol.SUBTRACTION, right)).isEqualTo(new Number(1)),
                () -> assertThat(left.calculate(Symbol.MULTIPLICATION, right)).isEqualTo(new Number(2)),
                () -> assertThat(left.calculate(Symbol.DIVISION, right)).isEqualTo(new Number(2))
        );
    }
}
