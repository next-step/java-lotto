package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("null 또는 빈 값 테스트")
    void nullOrEmptyTest() {
        int result1 = StringCalculator.splitAndSum(null);
        int result2 = StringCalculator.splitAndSum("");

        assertThat(result1).isEqualTo(0);
        assertThat(result2).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자1개 테스트")
    void split_숫자하나Test() {
        int result = StringCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("구분자를 기준으로 분리")
    void splitTest() {
        int result = StringCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("커스텀 구분자로 분리")
    void customSeparatorSplitTest() {
        int result = StringCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
}
