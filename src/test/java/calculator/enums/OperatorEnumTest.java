package calculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorEnumTest {

    @Test
    @DisplayName("연산자 판별 및 연산 테스트")
    void fromString_toSymbol() {
        assertThat(OperatorEnum.calculate("+", 10, 1)).isEqualTo(11);
        assertThat(OperatorEnum.calculate("-", 10, 1)).isEqualTo(9);
        assertThat(OperatorEnum.calculate("*", 10, 1)).isEqualTo(10);
        assertThat(OperatorEnum.calculate("/", 10, 1)).isEqualTo(10);
    }

}
