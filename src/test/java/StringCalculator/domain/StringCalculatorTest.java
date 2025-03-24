package StringCalculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringCalculatorTest {
    @DisplayName("문자열 계산기를 생성 할 수 있다.")
    @Test
    void createTest() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");

        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("우선순위를 갖지 않고 앞에서 부터 사칙연산을 진행한다.")
    @Test
    void calculateTest() {
        StringCalculator stringCalculator = new StringCalculator("2 + 3 * 4 / 2");

        int sut = stringCalculator.calculate();

        assertThat(sut).isEqualTo(10);
    }
}
