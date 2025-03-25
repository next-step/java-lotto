package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.exception.InvalidNumberInputException;
import calculator.exception.UnexpectedCharacterException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NumberTest {

    @Nested
    @DisplayName("Number 객체를 생성한다.")
    class construct {

        @DisplayName("null, 공백 문자열로 Number 를 생성할 수 없다.")
        @ParameterizedTest
        @NullAndEmptySource
        void nullAndEmpty(String text) {
            assertThatExceptionOfType(InvalidNumberInputException.class).isThrownBy(
                () -> new Number(text));
        }

        @DisplayName("숫자가 아닌 문자열로 Number 를 생성할 수 없다.")
        @ParameterizedTest
        @ValueSource(strings = {"a", "+"})
        void notNumber(String text) {
            assertThatExceptionOfType(UnexpectedCharacterException.class).isThrownBy(
                () -> new Number(text));
        }

        @DisplayName("숫자인 문자열을 통해 Number 객체를 생성할 수 있다.")
        @Test
        void number() {
            assertThat(new Number("3")).isEqualTo(new Number(3));
        }
    }

    @Nested
    @DisplayName("사칙 연산을 수행한다.")
    class calculate {

        @DisplayName("덧셈을 수행할 수 있다.")
        @Test
        void add() {
            Number left = new Number("1");
            Number right = new Number("2");
            assertThat(left.add(right)).isEqualTo(new Number("3"));
        }

        @DisplayName("뺄셈을 수행할 수 있다.")
        @Test
        void subtract() {
            Number left = new Number("2");
            Number right = new Number("1");
            assertThat(left.subtract(right)).isEqualTo(new Number("1"));
        }

        @DisplayName("곱셈을 수행할 수 있다.")
        @Test
        void multiplyBy() {
            Number left = new Number("4");
            Number right = new Number("2");
            assertThat(left.multiplyBy(right)).isEqualTo(new Number("8"));
        }

        @DisplayName("나눗셈을 수행할 수 있다.")
        @Test
        void divideBy() {
            Number left = new Number("4");
            Number right = new Number("2");
            assertThat(left.divideBy(right)).isEqualTo(new Number("2"));
        }
    }
}
