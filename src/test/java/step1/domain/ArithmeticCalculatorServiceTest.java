package step1.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorServiceTest {

    @Test
    public void 계산값확인() {
        ArithmeticCalculatorService from = ArithmeticCalculatorService.from("2 + 3 * 4 / 2");
        from.calculator();
        assertThat(from.getCalculatorResult()).isEqualTo(10);
    }
}
