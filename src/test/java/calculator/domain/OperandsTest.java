package calculator.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class OperandsTest {
    @DisplayName("피연산자들을 생성한다.")
    @Test
    void create() {
        OperandNumber number8 = new OperandNumber("8");
        OperandNumber number2 = new OperandNumber("2");
        Operands operands = new Operands(List.of(number8, number2));

        assertThat(operands).extracting("operands", as(InstanceOfAssertFactories.LIST))
                .contains(number8, number2);
    }
}