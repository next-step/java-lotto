package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 덧셈 계산기 테스트")
public class CalculatorTest {

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열에서 숫자를 분리할 수 있다.")
    @Test
    public void extractNumbersTest() {
        // given
        String input = "1,2:3";

        // when
        int[] numbers = Calculator.extractNumbers(input);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }

    @DisplayName("//와 \\n 사이에 위치하는 문자를 커스텀 구분자로 사용할 수 있다.")
    @Test
    public void customDelimiterTest() {
        // given
        String input = "//;\\n1;2;3";

        // when
        int[] numbers = Calculator.extractNumbers(input);

        // then
        assertThat(numbers).containsExactly(1, 2, 3);
    }
}
