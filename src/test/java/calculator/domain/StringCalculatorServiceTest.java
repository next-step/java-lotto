package calculator.domain;

import calculator.service.StringCalculatorService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorServiceTest {
    @Test
    @DisplayName("사칙연산을 순서대로 수행하는 테스트")
    void calculateTest() {
        assertThat(StringCalculatorService.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
