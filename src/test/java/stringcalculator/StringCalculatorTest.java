package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static stringcalculator.StringCalculator.*;

public class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @Test
    void 모든_사칙연산() {
        Integer result = stringCalculator.main("5 + 4 - 3 * 2 / 2");

        assertThat(result).isEqualTo(6);
    }

    @Test
    void 덧셈() {
        Integer result1 = stringCalculator.main("2 + 3");

        assertThat(result1).isEqualTo(5);


        Integer result2 = stringCalculator.main("4 + 3 + 2 + 1");

        assertThat(result2).isEqualTo(10);
    }

    @Test
    void 뺄셈() {
        Integer result1 = stringCalculator.main("2 - 3");

        assertThat(result1).isEqualTo(-1);


        Integer result2 = stringCalculator.main("4 + 3 - 2 - 1");

        assertThat(result2).isEqualTo(4);
    }


    @Test
    void 곱셈() {
        Integer result1 = stringCalculator.main("2 * -3");

        assertThat(result1).isEqualTo(-6);


        Integer result2 = stringCalculator.main("4 * 3 - 2 + 1");

        assertThat(result2).isEqualTo(11);
    }


    @Test
    void 나눗셈() {
        Integer result1 = stringCalculator.main("3 / 2");

        assertThat(result1).isEqualTo(1);


        Integer result2 = stringCalculator.main("4 / 3 - 2 + 1");

        assertThat(result2).isEqualTo(0);
    }

    @Test
    void 입력값이_null() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.main(null);
        }).withMessage(ERRMSG_ENTERED_NULL_OR_EMPTY_STRING);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.main("");
        }).withMessage(ERRMSG_ENTERED_NULL_OR_EMPTY_STRING);
    }

    @Test
    void 사칙연산_기호가_아닌_경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            stringCalculator.main("2 & 3");
        }).withMessage(ERRMSG_ONLY_NUMBERS_AND_OPERATORS_ALLOWED);
    }
}
