package calculator.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorEnumTest {


    @Test
    @DisplayName("연산자로 enum 반환 테스트")
    void fromString_toSymbol() {
        assertThat(OperatorEnum.fromString("+")).isEqualTo(OperatorEnum.ADD);
        assertThat(OperatorEnum.fromString("-")).isEqualTo(OperatorEnum.SUBSTRACT);
        assertThat(OperatorEnum.fromString("*")).isEqualTo(OperatorEnum.MULTIPLY);
        assertThat(OperatorEnum.fromString("/")).isEqualTo(OperatorEnum.DIVIDE);
    }

}
