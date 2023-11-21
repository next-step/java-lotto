package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    @DisplayName("단순 사칙연산 테스트")
    @Test
    void calculateTest(){
        assertThat(Operator.PLUS.calculate(4, 2)).isEqualTo(6);
        assertThat(Operator.MINUS.calculate(4, 2)).isEqualTo(2);
        assertThat(Operator.MULTIPLE.calculate(4, 2)).isEqualTo(8);
        assertThat(Operator.DIVIDE.calculate(4, 2)).isEqualTo(2);
    }

    @DisplayName("나눗셈 결과 정수 여부 테스트")
    @Test
    void divideResultIntegerTest(){
        assertThat(Operator.DIVIDE.calculate(5, 2)).isEqualTo(2);
    }
}
