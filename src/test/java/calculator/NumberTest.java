package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import calculator.domain.Number;
import calculator.domain.exception.InvalidNumberInputException;
import calculator.domain.exception.UnexpectedCharacterException;
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
                () -> new calculator.domain.Number(text));
        }

        @DisplayName("숫자가 아닌 문자열로 Number 를 생성할 수 없다.")
        @ParameterizedTest
        @ValueSource(strings = {"a", "+"})
        void notNumber(String text) {
            assertThatExceptionOfType(UnexpectedCharacterException.class).isThrownBy(
                () -> new calculator.domain.Number(text));
        }

        @DisplayName("숫자인 문자열을 통해 Number 객체를 생성할 수 있다.")
        @Test
        void number() {
            assertThat(new calculator.domain.Number("3")).isEqualTo(
                new calculator.domain.Number(3));
        }
    }

    @Nested
    @DisplayName("사칙 연산을 수행한다.")
    class calculate {

        @DisplayName("덧셈을 수행할 수 있다.")
        @Test
        void add() {
            calculator.domain.Number left = new calculator.domain.Number("1");
            calculator.domain.Number right = new calculator.domain.Number("2");
            assertThat(left.add(right)).isEqualTo(new calculator.domain.Number("3"));
        }

        @DisplayName("뺄셈을 수행할 수 있다.")
        @Test
        void subtract() {
            calculator.domain.Number left = new calculator.domain.Number("2");
            calculator.domain.Number right = new calculator.domain.Number("1");
            assertThat(left.subtract(right)).isEqualTo(new calculator.domain.Number("1"));
        }

        @DisplayName("곱셈을 수행할 수 있다.")
        @Test
        void multiplyBy() {
            calculator.domain.Number left = new calculator.domain.Number("4");
            calculator.domain.Number right = new calculator.domain.Number("2");
            assertThat(left.multiplyBy(right)).isEqualTo(new calculator.domain.Number("8"));
        }

        @DisplayName("나눗셈을 수행할 수 있다.")
        @Test
        void divideBy() {
            calculator.domain.Number left = new calculator.domain.Number("4");
            calculator.domain.Number right = new calculator.domain.Number("2");
            assertThat(left.divideBy(right)).isEqualTo(new Number("2"));
        }
    }
}
