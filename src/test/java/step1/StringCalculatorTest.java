package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step1.enums.ExceptionMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/*
- 더하기를 한다. O
- 뺄셈을 한다. O
- 곱하기를 한다. O
- 나눗셈을 한다. O
- 나눗셈시 소수점은 내림을 한다. O
- 입력값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException을 발생시킨다. O
- 사칙연산 기호가 아닌 다른 기호가 들어오면 IllegalArgumentException을 발생시킨다. O
*/
public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @DisplayName("덧셈 테스트를 한다.")
    @Test
    void plusTest() {
        int num1 = 1;
        int num2 = 2;

        assertThat(stringCalculator.plus(num1, num2)).isEqualTo(3);
    }

    @DisplayName("뺄셈테스트를 한다.")
    @Test
    void minusTest() {
        int num1 = 1;
        int num2 = 2;

        assertThat(stringCalculator.minus(num1, num2)).isEqualTo(-1);
    }

    @DisplayName("곱셈 테스트를 한다.")
    @Test
    void multiplyTest() {
        int num1 = 1;
        int num2 = 2;

        assertThat(stringCalculator.multiple(num1, num2)).isEqualTo(2);
    }

    @DisplayName("나눗셈 테스트를 한다.")
    @Test
    void divisionTest() {
        int num1 = 1;
        int num2 = 2;

        assertThat(stringCalculator.division(num1, num2)).isEqualTo(0);
    }

    @DisplayName("나눗셈 테스트시 소수점이면 내림을 한다.")
    @Test
    void divisionDownTest() {
        int num1 = 3;
        int num2 = 2;

        assertThat(stringCalculator.division(num1, num2)).isEqualTo(1);
    }

    @DisplayName("배열을 입력받아 계산을 한다.")
    @Test
    void calculateTest() {
        String str = "2 + 3 * 4 / 2";

        assertThat(stringCalculator.start(str)).isEqualTo(10);
    }

    @DisplayName("null혹은 비어있는 값이 들어왔을 시 예외를 발생시킨다.")
    @Test
    void inputValueNullOrEmptyThrowException() {
        String str = "2 + 3    4 / 2";

        assertThatThrownBy(() -> stringCalculator.start(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.NULL_EMPTY_EXCEPTION.message());
    }

    @DisplayName("+,-,/,*가 아닌 다른 기호가 들어오면 예외를 발생시킨다.")
    @Test
    void inputValueContainsAnotherThrowException() {
        String str = "2 + 3 ^ 4 / 2";

        assertThatThrownBy(() -> stringCalculator.start(str))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.SYMBOL_EXCEPTION.message());
    }

}
