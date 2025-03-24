import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArithmeticOperatorTest {

    @Test
    @DisplayName("덧셈 연산을 수행한다.")
    void addition() {
        assertThat(ArithmeticOperator.ADDITION.operate(2, 3)).isEqualTo(5);
    }

    @Test
    @DisplayName("뺄셈 연산을 수행한다.")
    void subtraction() {
        assertThat(ArithmeticOperator.SUBTRACTION.operate(5, 3)).isEqualTo(2);
    }

    @Test
    @DisplayName("곱셈 연산을 수행한다.")
    void multiplication() {
        assertThat(ArithmeticOperator.MULTIPLICATION.operate(2, 3)).isEqualTo(6);
    }

    @Test
    @DisplayName("나눗셈 연산을 수행한다.")
    void division() {
        assertThat(ArithmeticOperator.DIVISION.operate(6, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("0으로 나누면 예외가 발생한다.")
    void divisionByZero() {
        assertThatThrownBy(() -> ArithmeticOperator.DIVISION.operate(6, 0))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("연산자 기호를 반환한다.")
    void getSymbol() {
        assertThat(ArithmeticOperator.ADDITION.getSymbol()).isEqualTo("+");
        assertThat(ArithmeticOperator.SUBTRACTION.getSymbol()).isEqualTo("-");
        assertThat(ArithmeticOperator.MULTIPLICATION.getSymbol()).isEqualTo("*");
        assertThat(ArithmeticOperator.DIVISION.getSymbol()).isEqualTo("/");
    }

    @Test
    @DisplayName("지원하는 연산자인지 확인한다.")
    void isValidOperator() {
        assertThat(ArithmeticOperator.isValidOperator("+")).isTrue();
        assertThat(ArithmeticOperator.isValidOperator("-")).isTrue();
        assertThat(ArithmeticOperator.isValidOperator("*")).isTrue();
        assertThat(ArithmeticOperator.isValidOperator("/")).isTrue();
        assertThat(ArithmeticOperator.isValidOperator("%")).isFalse();
    }

    @Test
    @DisplayName("기호로 연산자를 찾는다.")
    void fromSymbol() {
        assertThat(ArithmeticOperator.fromSymbol("+")).isEqualTo(ArithmeticOperator.ADDITION);
        assertThat(ArithmeticOperator.fromSymbol("-")).isEqualTo(ArithmeticOperator.SUBTRACTION);
        assertThat(ArithmeticOperator.fromSymbol("*")).isEqualTo(ArithmeticOperator.MULTIPLICATION);
        assertThat(ArithmeticOperator.fromSymbol("/")).isEqualTo(ArithmeticOperator.DIVISION);
    }

    @Test
    @DisplayName("지원하지 않는 연산자 기호로 찾으면 예외가 발생한다.")
    void fromSymbolWithInvalidOperator() {
        assertThatThrownBy(() -> ArithmeticOperator.fromSymbol("%"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("지원하지 않는 연산자입니다: %");
    }
} 