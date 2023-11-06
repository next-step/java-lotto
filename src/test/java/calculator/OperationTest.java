package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperationTest {

    @Test
    void 사칙연산으로_Operation_enum을_찾을_수_있다() {
        assertAll(
            () -> {
                Operation actual = Operation.searchBy("+");
                Operation expected = Operation.PLUS;
                assertThat(actual).isEqualTo(expected);
            },
            () -> {
                Operation actual = Operation.searchBy("-");
                Operation expected = Operation.MINUS;
                assertThat(actual).isEqualTo(expected);
            },
            () -> {
                Operation actual = Operation.searchBy("*");
                Operation expected = Operation.MULTIPLICATION;
                assertThat(actual).isEqualTo(expected);
            },
            () -> {
                Operation actual = Operation.searchBy("/");
                Operation expected = Operation.DIVISION;
                assertThat(actual).isEqualTo(expected);
            }
        );
    }

    @Test
    void 사칙연산이_아닌_문자열로는_Operation_enum을_찾으면_예외처리된다() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Operation.searchBy("a"));
    }

    @ParameterizedTest
    @CsvSource({"+, 1, 1, 2", "-, 1, 1, 0", "*, 2, 2, 4", "/, 6, 3, 2"})
    void 사칙연산을_할_수_있다(String target, int number1, int number2, int expected) {
        Operation operation = Operation.searchBy(target);

        int actual = operation.calculate(number1, number2);

        assertThat(actual).isEqualTo(expected);
    }

}
