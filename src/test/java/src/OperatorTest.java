package src;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OperatorTest {

    @Test
    void 사칙연산_기호가_아닌_경우_IllegalArgumentException() {
        // given
        String invalidValue = "(";

        // when then
        assertThatThrownBy(() -> Operator.byString(invalidValue))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,+,3", "1,2,-,-1", "1,2,*,2","1,2,/,0"}, delimiter = ',')
    void 사칙_연산자에_따라_연산을_할_수_있다(int num1, int num2, String stringOperation, int expectedResult) {
        // given
        Operator operator = Operator.byString(stringOperation);

        // when
        int result = operator.operate(num1, num2);

        // then
        assertThat(result).isEqualTo(expectedResult);
    }
}

