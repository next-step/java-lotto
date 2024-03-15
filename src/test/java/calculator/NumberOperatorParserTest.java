package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NumberOperatorParserTest {

    @DisplayName("요청 문자열을 Number와 Operators에 담는다.")
    @Test
    void setNumberAndOperatorsByInput() {
        // given
        String input = "1 + 3 - 2";

        // when
        NumberOperatorParser parser = new NumberOperatorParser(input);
        Numbers numbers = parser.getNumbers();
        Operators operators = parser.getOperators();

        // then
        assertAll(
                () -> assertThat(numbers.nextNumber()).isEqualTo(1),
                () -> assertThat(numbers.nextNumber()).isEqualTo(3),
                () -> assertThat(numbers.nextNumber()).isEqualTo(2)
        );
        assertAll(
                () -> assertThat(operators.nextOperation()).isEqualTo(Operator.PLUS),
                () -> assertThat(operators.nextOperation()).isEqualTo(Operator.MINUS)
        );
    }

    @DisplayName("요청 문자열의 숫자와 연산자의 수를 검증하고, 맞지 않으면 IllegalArgumentException을 던진다.")
    @Test
    void throwIllegalArgumentExceptionAboutNumbersAndOperatorsMatch() {
        // given
        String input = "1 + 3 -";

        // then
        assertThrows(IllegalArgumentException.class, () -> new NumberOperatorParser(input));
    }
}