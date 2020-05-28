package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("계산식 FunctionalInterface? 클래스 테스트")
class YieldTest {
    @Test
    @DisplayName("수익률 계산 결과 테스트")
    void calculateTesT() {
        double result = 0.35;
        double calculate = Yield.calculate(5000, 14000);

        assertThat(calculate).isEqualTo(result);
    }
}