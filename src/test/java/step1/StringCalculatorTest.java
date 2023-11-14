package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("두 문자열을 더한다.")
    void sumTest() {
        // given
        String left = "1";
        String right = "2";

        // when
        int add = stringCalculator.add(left, right);

        // then
        assertThat(add).isEqualTo(3);
    }

    @Test
    @DisplayName("왼쪽 수에서 오른쪽 수를 뺀다.")
    void minusTest() {
        // given
        String left = "3";
        String right = "2";

        // when
        int minus = stringCalculator.minus(left, right);

        // then
        assertThat(minus).isEqualTo(1);
    }

    @Test
    @DisplayName("두 숫자를 곱한다.")
    void multiplyTest() {
        // given
        String left = "3";
        String right = "2";

        // when
        int multiply = stringCalculator.multiply(left, right);

        // then
        assertThat(multiply).isEqualTo(6);
    }

    @Test
    @DisplayName("왼쪽 수를 오른쪽 수로 나눈다.")
    void divideTest() {
        // given
        String left = "6";
        String right = "2";

        // when
        int divide = stringCalculator.divide(left, right);

        // then
        assertThat(divide).isEqualTo(3);
    }

}
