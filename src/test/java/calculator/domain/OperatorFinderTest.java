package calculator.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorFinderTest {

    @DisplayName("주어진 연산자에 맞는 연산자 객체를 찾고 해당 연산을 수행 할 수 있다.")
    @Test
    void test() {
        String operatorStr = "*";
        Operator foundOperator = OperatorFinder.findOperator(operatorStr);

        assertThat(foundOperator).isNotNull();
        assertThat(foundOperator.calculate(10, 5)).isEqualTo(50);
    }
}